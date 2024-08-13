package com.comcast.scm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con = null;

	public void getDBconnection(String url,String username,String password) throws SQLException {
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
		}
	}

	public void closeDBconnection() throws SQLException {
		con.close();
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
		    result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement stat = con.createStatement();
		   result = stat.executeUpdate(query);
		} catch (Exception e) {}
		
		return result;
		
	}

	}

