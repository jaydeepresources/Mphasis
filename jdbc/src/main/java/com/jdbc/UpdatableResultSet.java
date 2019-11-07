package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdatableResultSet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "blackthorne");
		System.out.println("Connection is created");

		PreparedStatement stmt = con.prepareStatement("select * from posts", ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.absolute(2);
		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		rs.first();
		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		rs.moveToInsertRow();
		
        rs.updateString("title", "inserting a new title...");
        rs.updateString("body", "inserting a new title's body...");
        rs.insertRow();
        rs.moveToCurrentRow();
        rs.last();
        System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
	}

}
