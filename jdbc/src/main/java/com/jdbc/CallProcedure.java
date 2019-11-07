package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallProcedure {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "blackthorne");
		System.out.println("Connection is created");
		
		CallableStatement cst = con.prepareCall("call updateTitle(?,?)");
		cst.setInt(1, 1);
		cst.setString(2, "new post title");
		cst.registerOutParameter(2, Types.VARCHAR);
		
		int res = cst.executeUpdate();
		String title = cst.getString(2);
		System.out.println(title);

	}

}
