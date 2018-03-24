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
import com.airlines.ws.domain.UserDetailsDTO;
import com.airlines.ws.services.intf.SignupServices;

@Component
@RestController
public class SignUpController {

	@Value("${signUpSuccess}")
	private String signUpSuccess;
	
	@Value("${signUpFailure}")
	private String signUpFailure;
	
	@Autowired
	private SignupServices signupServices;
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/createUser",
			method = RequestMethod.POST, 
			produces = { "application/json", "application/xml" })
	public ResponseMessage createUser(@RequestBody UserDetailsDTO userDetailsDTO ) {
		ResponseMessage response = null;
		System.out.println("userDetailsDTO firstname : " + userDetailsDTO.getFirstname());
		System.out.println("userDetailsDTO MiddleName : " + userDetailsDTO.getMiddlename());
		response = validateUserInfo(userDetailsDTO);
		if(response != null) 
			return response;
		
		Integer persistID = signupServices.signUp(userDetailsDTO);
		System.out.println("From signup Controller persistID : " + persistID);
		response = persistID > 0 ? new ResponseMessage(signUpSuccess) : new ResponseMessage(signUpFailure) ; 
		return response;
	}


	private ResponseMessage validateUserInfo(UserDetailsDTO userDetailsDTO) {
		ResponseMessage response = null;
		if(userDetailsDTO.getFirstname() == null  || userDetailsDTO.getFirstname().equals("")) {
			return new ResponseMessage("Firstname mandatory");
		} else if(userDetailsDTO.getEmail() == null || userDetailsDTO.getEmail().equals("")) {
			return new ResponseMessage("Email is mandatory");
		} else if(userDetailsDTO.getPassword() == null || userDetailsDTO.getPassword().equals("")) {
			return new ResponseMessage("Password is mandatory");
		} else if(userDetailsDTO.getConfirmpassword() == null || userDetailsDTO.getConfirmpassword().equals("")) {
			return new ResponseMessage("Confirmpassword is mandatory");
		} else if(!userDetailsDTO.getPassword().equals(userDetailsDTO.getConfirmpassword())){
			System.out.println("Password()     " + userDetailsDTO.getPassword());
			System.out.println("getConfirmpassword()     " + userDetailsDTO.getConfirmpassword());
			return new ResponseMessage("Passwords are not same");
		} else if(userDetailsDTO.getCountry() == null || userDetailsDTO.getCountry().equals("")){
			return new ResponseMessage("Please select country");
		}
		return response;
	}
}
