package com.db.employeeManagementSystem.dao;
import com.db.employeeManagementSystem.bean.Login;

public interface LoginDAO {
	public boolean authenticate(Login login);
	
}
