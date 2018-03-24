package com.airlines.ws.services.intf;

import com.airlines.ws.domain.UserCredentialDTO;

public interface LoginServices {
	public UserCredentialDTO login(UserCredentialDTO userCredential);
}
