package com.hrms.API.steps.practice;

public class HardCodedConstants {

	public static String updateCreatedEmpBody() {
		
		/**
		 * employeeID is static variable to be able to call it i have to use class name which is HardcodedExamples
		 */
		String updateBody="{\r\n" + 
				"  \"employee_id\": \""+ HardcodedExamples.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"ziya\",\r\n" + 
				"  \"emp_lastname\": \"basan\",\r\n" + 
				"  \"emp_middle_name\": \"mistik\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"2000-07-16\",\r\n" + 
				"  \"emp_status\": \"Worker\",\r\n" + 
				"  \"emp_job_title\": \"Developer\"\r\n" + 
				"}";
	
		return updateBody;
	}
	
	
}
