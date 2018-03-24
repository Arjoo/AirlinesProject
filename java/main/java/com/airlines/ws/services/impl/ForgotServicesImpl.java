package com.airlines.ws.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.dao.intf.ForgotPasswordDAO;
import com.airlines.ws.domain.ForgotPasswordDTO;
import com.airlines.ws.services.intf.ForgotPasswordServices;

@Service("forgotPasswordServices")
public class ForgotServicesImpl implements ForgotPasswordServices {

	
	@Autowired
	private ForgotPasswordDAO forgotPasswordDAO;
	
	
	@Override
	public String forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		String status = "";
		int userId = forgotPasswordDAO.getUserId(forgotPasswordDTO);
		if(userId == 0) {
			status = "Invalid";
		}
		forgotPasswordDAO.forgotPassword(userId, forgotPasswordDTO);
		return status;
	}

}
