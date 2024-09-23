package com.jdbc.main.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMainDemo {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("please enter your choise");
		System.out.println("0 - exit");
		System.out.println("1 - select ");
		System.out.println("2 - create ");
		System.out.println("3 - update ");

		int choise = sc.nextInt();

		Connection con = null;
		Statement stmt = null;

		PreparedStatement pstmt = null;
		ResultSet resultset = null;

		String url = "jdbc:mysql://127.0.0.1:3306/my_codebegun_db";
		String user = "root";
		String pwd = "root";

		if (choise == 1) {

			System.out.println("Please enter student id :: ");
			int studentid = sc.nextInt();

			String query = "select * from STUDENT_INFO where STUDENTID = ?";// +studentid;
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, studentid);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				System.out.println(resultset.getString("FIRSTNAME"));
				System.out.println(resultset.getInt("STUDENTID"));
				
				

			}
		} else if (choise == 2) {
			String insertquery = "INSERT INTO STUDENT_INFO (FIRSTNAME,MIDDLENAME,LASTNAME,CREATEDUSER,UPDATEDUSER,ACTIVESTATUS) "
					+ "values(?,?,?,?,?,?)";

			con = DriverManager.getConnection(url, user, pwd);

			pstmt = con.prepareStatement(insertquery);

			System.out.println("PLeas eenter student name::: ");
			String name = sc.next();

			pstmt = con.prepareStatement(insertquery);
			pstmt.setString(1, name);
			pstmt.setString(2, "M");
			pstmt.setString(3, "L");
			pstmt.setString(4, "SYSTEM");
			pstmt.setString(5, "SYSTEM");
			pstmt.setByte(6, (byte) 1);

			pstmt.execute();

		} else if (choise == 3) {
			String insertquery = "UPDATE STUDENT_INFO SET MIDDLENAME= ? WHERE STUDENTID =?";

			con = DriverManager.getConnection(url, user, pwd);

//			pstmt = con.prepareStatement(insertquery);

			System.out.println("Pleas mName: ");
			String mName = sc.next();
			System.out.println("Pleas mName: ");
			int stdentId = sc.nextInt();

			pstmt = con.prepareStatement(insertquery);
			pstmt.setString(1, mName);
			pstmt.setInt(2, stdentId);

			int statues = pstmt.executeUpdate();
			
			
			if(statues>=1) {
				System.out.println("Student Update success ::: ");
			}else {
				System.out.println("Student Update un-success ::: ");
			}

		}

	}

}
