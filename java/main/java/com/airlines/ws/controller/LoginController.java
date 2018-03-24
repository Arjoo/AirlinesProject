package com.airlines.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.ws.constants.ResponseMessage;
import com.airlines.ws.domain.UserCredentialDTO;
import com.airlines.ws.services.intf.LoginServices;

@Component
@RestController
public class LoginController {

	@Value("${loginSuccess}")
	private String loginSuccess;
	
	@Value("${loginFailure}")
	private String loginFailure;
	
	@Autowired
	private LoginServices loginServices;
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/login", 
			method = RequestMethod.POST, 
			produces = { "application/json", "application/xml" })
	public UserCredentialDTO login(@RequestBody UserCredentialDTO userCredentialDTO) {
		System.out.println("userCredentialDTO email    " + userCredentialDTO.getEmail());
		System.out.println("userCredentialDTO Password  " + userCredentialDTO.getPassword());
		
		UserCredentialDTO signinUser = loginServices.login(userCredentialDTO);
		
		return signinUser;
	}

	
	
}
