package com.airlines.ws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.dao.intf.SignUpDAO;
import com.airlines.ws.domain.UserDetailsDTO;
import com.airlines.ws.model.Signup;

@Transactional
@Repository("signUpDAO")
public class SignupDAOImpl implements SignUpDAO {

	@Autowired
	private HibernateTemplate loginHibernateTemplate;
	
	@Override
	public Integer signUp(UserDetailsDTO userDetailsDTO) {
		
		Signup signup = convertDtoToDao(userDetailsDTO);
		Integer persistID = (Integer)loginHibernateTemplate.save(signup);
		System.out.println("persistID : " + persistID);
		return persistID;
	}

	private Signup convertDtoToDao(UserDetailsDTO userDetailsDTO) {
		Signup signup = new Signup();
		signup.setFirstname(userDetailsDTO.getFirstname());
		signup.setMiddlename(userDetailsDTO.getMiddlename());
		signup.setLastname(userDetailsDTO.getLastname());
		signup.setEmail(userDetailsDTO.getEmail());
		signup.setPassword(userDetailsDTO.getPassword());
		signup.setConfirmpassword(userDetailsDTO.getConfirmpassword());
		signup.setCountry(userDetailsDTO.getCountry());
		signup.setMobile(userDetailsDTO.getMobilenumber());
		
		return signup;
	}

}
