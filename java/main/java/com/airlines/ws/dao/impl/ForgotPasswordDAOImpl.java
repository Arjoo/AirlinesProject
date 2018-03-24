package com.airlines.ws.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.dao.intf.ForgotPasswordDAO;
import com.airlines.ws.domain.ForgotPasswordDTO;
import com.airlines.ws.model.Signup;

@Transactional
@Repository("forgotPasswordDAO")
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {
	
	@Autowired
	private HibernateTemplate forgotPasswordHibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public int getUserId(ForgotPasswordDTO forgotPasswordDTO) {
		int userId = 0;
		String query = "from Signup s where s.email= :email";
		ValueBean valueBean = new ValueBean(forgotPasswordDTO.getEmail());
		List<Signup> signup = (List<Signup>)forgotPasswordHibernateTemplate.findByValueBean(query, valueBean);
		if(signup.size() != 0)
			return signup.get(0).getId();
			
		return userId;
	}

	@Override
	public void forgotPassword(int userId, ForgotPasswordDTO forgotPasswordDTO) {
		Signup signup = forgotPasswordHibernateTemplate.get(Signup.class, userId);
		if(signup != null) {
			signup.setPassword(forgotPasswordDTO.getNewpassword());
			signup.setConfirmpassword(forgotPasswordDTO.getConfirmpassword());
			forgotPasswordHibernateTemplate.flush();
		}
		
		System.out.println("DONE-----------------");
	}

}


class ValueBean {
	private String email;

	public ValueBean() {
		super();
	}

	public ValueBean(String email) {
		super();
		this.email = email;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
