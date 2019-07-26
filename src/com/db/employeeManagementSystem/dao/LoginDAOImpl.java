package com.db.employeeManagementSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.employeeManagementSystem.bean.Login;
import com.db.employeeManagementSystem.util.DbUtil;

public class LoginDAOImpl implements LoginDAO {
	
	public boolean authenticate(Login login){
		String query = "select * from login_table where username=? and password=?";
		Connection connection = null;
		connection = DbUtil.getConnection();
		PreparedStatement preparedstatemnt = null;
		ResultSet resultSet =null;
		connection = DbUtil.getConnection();
		try {
			preparedstatemnt = connection.prepareStatement(query);
			preparedstatemnt.setString(1, login.getUserName());
			preparedstatemnt.setString(2, login.getPassword());
			resultSet = preparedstatemnt.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtil.closeConnection(connection);
		}
		return false;
	}
}
