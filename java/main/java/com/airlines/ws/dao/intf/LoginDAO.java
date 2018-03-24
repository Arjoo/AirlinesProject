package com.airlines.ws.dao.intf;

import com.airlines.ws.domain.UserCredentialDTO;

public interface LoginDAO {
	
	public UserCredentialDTO login(UserCredentialDTO userCredential);

}
