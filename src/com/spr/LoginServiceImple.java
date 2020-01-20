package com.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImple implements LoginService{
	@Autowired
	private LoginDao Dao;
	@Override
	public Login validateUser(Login login) {
		
		return Dao.validateUser(login) ;
	}

}
