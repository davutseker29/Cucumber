package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCDemo {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	//jdbc:driver type:hostname:port/db name
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void abc() throws SQLException {
		//1-we need connection
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB conection is successful");
		//2-statement; connection helps us create a statement
		Statement st=conn.createStatement();
		//3-need to execute the query
		//4-will return me the ResultSet
		ResultSet rs=st.executeQuery("select * from hs_hr_employees");
		//when i am in the list i have to the next
		rs.next();
		String firstname=rs.getString("emp_firstname");
		System.out.println(firstname);
		//if i want to print next name
		rs.next();
		//if i dont know what type of data so i use object
		String firstname02=rs.getObject("emp_firstname").toString();
		System.out.println(firstname02);
		
		//to print all data in a column
		String allData;
		while(rs.next()) {
			allData=rs.getObject("emp_firstname").toString();
			System.out.println(allData);
			
		}
		//when we do closing(Connections between Eclipse and SQL) backward ResultSet, Statement and Connection
		rs.close();
		st.close();
		conn.close();
	}
	@Test
	public void task() throws SQLException {
		
		//retrieve all the job titles and store them in arraylist and show in it console it from arraylist
		
		//1-we need connection
				Connection connect=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				System.out.println("DB conection is successful");
				//2-statement; connection helps us create a statement
				Statement st=connect.createStatement();
				//3-need to execute the query
				//4-will return me the ResultSet
				ResultSet rs=st.executeQuery("select * from ohrm_job_title");
				
				List<String> jobTitles= new ArrayList<>();
				while(rs.next()) {
					jobTitles.add(rs.getObject("job_title").toString());
					
				}
				//if you wanna see in bracket no need to do for loop
				System.out.println(jobTitles);
				
				//if you wanna see them without bracket
				for (String it : jobTitles) {
					System.out.println(it);
					
				}
	}
}
