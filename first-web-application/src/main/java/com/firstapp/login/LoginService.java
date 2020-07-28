package com.firstapp.login;

public class LoginService {
	
	public boolean isUservalid(String user, String password) {
		if(user.equals("Reshma") && password.equals("password"))
			return true;
		return false;
		
	}

}
