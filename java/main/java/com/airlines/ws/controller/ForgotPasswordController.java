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
import com.airlines.ws.domain.ForgotPasswordDTO;
import com.airlines.ws.services.intf.ForgotPasswordServices;

@Component
@RestController
public class ForgotPasswordController {

	
	@Value("${forgotSuccess}")
	private String forgotSuccess;
	
	@Value("${forgotFailure}")
	private String forgotFailure;
	
	@Value("${blankEmail}")
	private String blankEmail;
	
	@Value("${enterPassword}")
	private String enterPassword;
	
	@Value("${enterConfirmPassword}")
	private String enterConfirmPassword;
	
	@Value("${passwordNotSame}")
	private String passwordNotSame;
	
	
	
	@Autowired
	private ForgotPasswordServices forgotPasswordServices;
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/forgotPassword",
			method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public ResponseMessage forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) {
		
		System.out.println("forgotPasswordDTO email  " + forgotPasswordDTO.getEmail());
		System.out.println("forgotPasswordDTO Password  " + forgotPasswordDTO.getNewpassword());
		System.out.println("forgotPasswordDTO Confirmpassword  " + forgotPasswordDTO.getConfirmpassword());
		
		String validateMsg = validate(forgotPasswordDTO);
		System.out.println("validateMsg     " + validateMsg);
		if(!validateMsg.equals(""))
			return new ResponseMessage(validateMsg);
		
		String status = forgotPasswordServices.forgotPassword(forgotPasswordDTO);
		return status.equals("") ? new ResponseMessage(forgotSuccess) : new ResponseMessage(forgotFailure);
	}


	private String validate(ForgotPasswordDTO forgotPasswordDTO) {
		String msg = "";
		String email = forgotPasswordDTO.getEmail();
		String newPassword = forgotPasswordDTO.getNewpassword();
		String confirmPassword = forgotPasswordDTO.getConfirmpassword();


		if(email == null || "".equals(email)) {
			msg = blankEmail; 
		} else if(newPassword == null || "".equals(newPassword)) {
			msg = enterPassword;
		} else if(confirmPassword == null || "".equals(confirmPassword)) {
			msg = enterConfirmPassword;
		} else if(!newPassword.equals(confirmPassword)) {
			msg = passwordNotSame;
		}
		
		return msg;
	}
	
}
