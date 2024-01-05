package com.jdbcproject.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DynamicProjectApp {
	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
	
		String url="jdbc:mysql://localhost:3306/jdbc_database";
		String username="root";
		String password="Kodnest123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		
		Connection con=DriverManager.getConnection(url, username, password);
		System.out.println("Connection is set");
		
		System.out.println("Enter the table name:");
		String tablename=scan.next();
		
		System.out.println("Enter 1 for creating table 2 for showing tables, 3 for insert, 4 for updating, "
					+ "5 for deleting and 6 for select and any other number to terminate");	
		int choice=scan.nextInt();
		switch(choice){
			case 1:DynamicProject.createtable(con,tablename);
			break;
			case 2:DynamicProject.showtables(con);
			break;
			case 3:DynamicProject.insert(con,tablename);
			break;
			case 4:DynamicProject.update(con,tablename);
			break;
			case 5:DynamicProject.delete(con,tablename);
			break;
			case 6:DynamicProject.select(con,tablename);
			break;
			default:System.out.println("Incorrect choice");
			}
		}
	}



