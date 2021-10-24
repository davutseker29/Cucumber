package com.hrms.API.utils;

import com.hrms.API.steps.practice.HardcodedExamples;
import org.json.JSONObject;

public class PayloadConstants {

	/**
	 * Create employee body
	 * 
	 * @return
	 */
	public static String createEmployeeBody() {

		String createEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"hakki\",\r\n"
				+ "  \"emp_lastname\": \"kimsavunur\",\r\n" + "  \"emp_middle_name\": \"ziya\",\r\n"
				+ "  \"emp_gender\": \"F\",\r\n" + "  \"emp_birthday\": \"2000-07-16\",\r\n"
				+ "  \"emp_status\": \"Worker\",\r\n" + "  \"emp_job_title\": \"Developer\"\r\n" + "}";
		return createEmployeeBody;
	}

	/**
	 * Creating payload using JSONObject and returning it as a String
	 * @return
	 */
	public static String createEmployeePayload() {

		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", "hakki");
		obj.put("emp_lastname", "kimsavunur");
		obj.put("emp_middle_name", "ziya");
		obj.put("emp_gender", "F");
		obj.put("emp_birthday", "2000-07-16");
		obj.put("emp_status", "Worker");
		obj.put("emp_job_title", "Developer");
		return obj.toString();
	}

	/**
	 * Created method to return payload - to reduce messy code
	 * 
	 * @return
	 */
	public static String updateCreatedEmpBody() {

		/**
		 * employeeID is static variable to be able to call it i have to use class name
		 * which is HardcodedExamples
		 */
		String updateBody = "{\r\n" + "  \"employee_id\": \"" + HardcodedExamples.employeeID + "\",\r\n"
				+ "  \"emp_firstname\": \"ziya\",\r\n" + "  \"emp_lastname\": \"basan\",\r\n"
				+ "  \"emp_middle_name\": \"mistik\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
				+ "  \"emp_birthday\": \"2000-07-16\",\r\n" + "  \"emp_status\": \"Worker\",\r\n"
				+ "  \"emp_job_title\": \"Developer\"\r\n" + "}";

		return updateBody;
	}

}
