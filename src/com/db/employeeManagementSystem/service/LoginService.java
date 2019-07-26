package com.db.employeeManagementSystem.service;

import com.db.employeeManagementSystem.bean.Login;

public interface LoginService {
	
	public boolean authenticate(Login login);
}
