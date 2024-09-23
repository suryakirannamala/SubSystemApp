package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		
		//MAVEN

		Connection con = null;
		Statement stmt = null;

		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		// "jdbc:mysql://localhost:3306"
		// int a=10, b=20;
		// 10+20
		// a+b
		int studentid = 4; // sc.getif;
		System.out.println("please enter your choise");
		System.out.println("1 - select ");
		System.out.println("2 - create ");

		String url = "jdbc:mysql://127.0.0.1:3306/my_codebegun_db";
		String user = "root";
		String pwd = "root";
		String query = "select * from STUDENT_INFO where STUDENTID = ?";// +studentid;

		String insertquery = "INSERT INTO STUDENT_INFO (FIRSTNAME,MIDDLENAME,LASTNAME,CREATEDUSER,UPDATEDUSER,ACTIVESTATUS) "
				+ "values(?,?,?,?,?,?)";// +studentid;

		try {
			con = DriverManager.getConnection(url, user, pwd);

//			stmt = con.createStatement();
//			boolean status = stmt.execute(query);
//			System.out.println(status);
			// resultset = stmt.executeQuery(query);

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, studentid);

			resultset = pstmt.executeQuery();

			pstmt = con.prepareStatement(insertquery);
			pstmt.setString(1, "Name1");
			pstmt.setString(2, "M");
			pstmt.setString(3, "L");
			pstmt.setString(4, "SYSTEM");
			pstmt.setString(5, "SYSTEM");
			pstmt.setByte(6, (byte) 1);
			pstmt.setDate(5, (java.sql.Date) new Date());

			pstmt.execute();

			while (resultset.next()) {
				System.out.println(resultset.getString("FIRSTNAME"));
				System.out.println(resultset.getInt("STUDENTID"));
				
				//sobj
				//sobj.setStudentId(resultset.getInt("STUDENTID"));
				//sobj.setStudentName(resultset.getString("FIRSTNAME"));
				//
				//slist.add(sobj);
				//smap.put(resultset.getInt("STUDENTID",sobj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
