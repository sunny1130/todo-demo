package com.example.tododemo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String u, String p) {
			
		return (u.equals("sun")&&p.equals("pass"));

	}
}
