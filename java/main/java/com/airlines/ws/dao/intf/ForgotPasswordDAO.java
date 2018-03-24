package com.airlines.ws.dao.intf;

import java.util.List;

import com.airlines.ws.domain.ForgotPasswordDTO;

public interface ForgotPasswordDAO {

	public void forgotPassword(int userId, ForgotPasswordDTO forgotPasswordDTO);

	public int getUserId(ForgotPasswordDTO forgotPasswordDTO);

}
