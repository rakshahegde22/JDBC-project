package com.jdbcproject.Project;

import java.sql.*;
import java.util.Scanner;

public class DynamicProject {
	
	public static void createtable(Connection con,String tablename) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		
		String query="CREATE TABLE "+tablename+"(id int,name varchar(25),salary int)";
		
		Statement stmt=con.createStatement();
		stmt.executeUpdate(query);
		
		System.out.println("Table is created");
	}
	
	public static void showtables(Connection con) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		
		String query="SHOW TABLES";
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("Tables are shown!");
	}
	

	public static void insert(Connection con,String tablename) throws Exception 
	{
		String query="INSERT INTO "+tablename+" VALUES(?,?,?)";
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of values to be inserted:");
		int n=scan.nextInt();
		
		PreparedStatement pstmt=null;
		
		for(int i=1;i<=n;i++) {
		System.out.println("Enter the id:");
		int id=scan.nextInt();
		System.out.println("Enter the name:");
		String Name=scan.next();
		System.out.println("Enter the salary:");
		int salary=scan.nextInt();
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, id);
		pstmt.setString(2, Name);
		pstmt.setInt(3, salary);
		
		pstmt.addBatch();
		}
		pstmt.executeBatch();
		System.out.println("Row is inserted.");
	}
	public static void update(Connection con,String tablename) throws Exception 
	{
		Scanner scan=new Scanner(System.in);
		
		String query="UPDATE "+tablename+" SET SALARY=? WHERE ID=?";
		
		System.out.println("Enter the number of rows to be updated:");
		int n=scan.nextInt();
		
		PreparedStatement pstmt=null;
		
		for(int i=1;i<=n;i++) {
		System.out.println("Enter the salary:");
		int salary=scan.nextInt();
		System.out.println("Enter the id:");
		int id=scan.nextInt();
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, salary);
		pstmt.setInt(2, id);
		
		pstmt.addBatch();
		}
		pstmt.executeBatch();
		System.out.println("Row is updated.");
	}
	public static void delete(Connection con,String tablename) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		
		String query="DELETE FROM "+tablename+" WHERE ID=?";
		
		System.out.println("Enter the number of rows to be deleted:");
		int n=scan.nextInt();
		
		for(int i=1;i<=n;i++) {
		System.out.println("Enter the id:");
		int id=scan.nextInt();
		
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, id);
		
		pstmt.execute();
		}
		System.out.println("Row is deleted");
	}
	public static void select(Connection con,String tablename) throws Exception 
	{
		Scanner scan=new Scanner(System.in);

		String query="SELECT * FROM "+tablename+" WHERE ID=?";
		
		System.out.println("Enter the number of rows to be retrived:");
		int n=scan.nextInt();
		
		for(int i=1;i<=n;i++) {
		System.out.println("Enter the id:");
		int id=scan.nextInt();
		
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));	
		}
		}
		System.out.println("Row is retrived");
	}
}


