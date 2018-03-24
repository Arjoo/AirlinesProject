package com.airlines.ws.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.constants.Signup;
import com.airlines.ws.dao.intf.LoginDAO;
import com.airlines.ws.domain.UserCredentialDTO;
import com.airlines.ws.services.intf.LoginServices;

@Service("loginServices")
public class LoginServicesImpl implements LoginServices {
	
	@Autowired
	private LoginDAO loginDAO; 
	
	public UserCredentialDTO login(UserCredentialDTO userCredential) {
		return loginDAO.login(userCredential);
	}
}
