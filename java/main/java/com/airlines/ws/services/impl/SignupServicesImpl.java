package com.airlines.ws.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.dao.intf.SignUpDAO;
import com.airlines.ws.domain.UserDetailsDTO;
import com.airlines.ws.services.intf.SignupServices;

@Service("signupServices")
public class SignupServicesImpl implements SignupServices {


	@Autowired
	private SignUpDAO signUpDAO; 
	
	@Override
	public Integer signUp(UserDetailsDTO userDetailsDTO) {
		Integer persistID = signUpDAO.signUp(userDetailsDTO);
		return persistID;
	}

}
