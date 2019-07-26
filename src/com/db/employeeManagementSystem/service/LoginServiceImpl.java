package com.db.employeeManagementSystem.service;

import com.db.employeeManagementSystem.bean.Login;
import com.db.employeeManagementSystem.dao.LoginDAO;
import com.db.employeeManagementSystem.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	LoginDAO loginDAO = new LoginDAOImpl();

	@Override
	public boolean authenticate(Login login) {
		
		return loginDAO.authenticate(login);
	}

}
