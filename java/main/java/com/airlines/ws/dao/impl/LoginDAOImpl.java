package com.airlines.ws.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.dao.intf.LoginDAO;
import com.airlines.ws.domain.UserCredentialDTO;
import com.airlines.ws.model.Signup;

@Transactional
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private HibernateTemplate loginHibernateTemplate;
	
	@Override
	public UserCredentialDTO login(UserCredentialDTO userCredentialDTO) {
		
		List<Signup> users = loginHibernateTemplate.loadAll(Signup.class);
		for(Signup user : users) {
			if(user.getPassword().equals(userCredentialDTO.getPassword()) &&
					user.getEmail().equals(userCredentialDTO.getEmail())) {
				userCredentialDTO.setUserId(user.getId());
			}
		}
		return userCredentialDTO;
	}

	private com.airlines.ws.constants.Signup convertToDTO(Signup user) {
		com.airlines.ws.constants.Signup signinUser = new com.airlines.ws.constants.Signup();
		signinUser.setConfirmpassword(user.getConfirmpassword());
		signinUser.setCountry(user.getCountry());
		signinUser.setEmail(user.getEmail());
		signinUser.setFirstname(user.getFirstname());
		signinUser.setId(user.getId());
		signinUser.setLastname(user.getLastname());
		signinUser.setMiddlename(user.getMiddlename());
		signinUser.setMobile(user.getMobile());
		signinUser.setPassword(user.getPassword());
		return signinUser;
	}

}
