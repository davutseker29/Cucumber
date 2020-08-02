package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * Rest assured static packages
 */
import static io.restassured.RestAssured.*; //written manual
import static org.hamcrest.Matchers.*; //written manual

/**
 * importing JUnit packages
 */
//please import
import org.junit.*;
import org.junit.runners.MethodSorters; //this is for @FixMethodOrder makes it work

import com.hrms.API.utils.PayloadConstants;

/**
 * we may use below - please comment out for now
 */
//import org.apache.hc.core5.http.ContentType;

/**
 * This @FixMethodOrder (MethodSorters.NAme_ascending) will execute @Test
 * annnotation in ascending alphabetical order
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

	/**
	 * Rest Assured
	 * 
	 * given - prepare your request when - you are making the call to the endpoint
	 * then - validating
	 * 
	 * @param args
	 */

	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTYzMTEwMjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NjM1NDIyOSwidXNlcklkIjoiOTA1In0.QzJcks8VNRier_f-VbgPefHTNbvQha1s-1fdDnAt2wE";
	public static String employeeID;

	public void sampleTestNotes() {

		/**
		 * BaseURI for all calls
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**
		 * JWT required for all calls- expires every 12 hours
		 */
		token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTYzMTEwMjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NjM1NDIyOSwidXNlcklkIjoiOTA1In0.QzJcks8VNRier_f-VbgPefHTNbvQha1s-1fdDnAt2wE";

		/**
		 * Preparing / getOneEmployee.php request
		 */

		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "22356A").log().all();

		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response prettyPrint() method converts JSON object into
		 * String and prints no need to SOP
		 */
		getOneEmployeeResponse.prettyPrint();

		/**
		 * this is the 2nd way
		 */
		// String response= getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {

		/**
		 * Preparing request for / createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"string\",\r\n" + "  \"emp_lastname\": \"string\",\r\n"
						+ "  \"emp_middle_name\": \"ziya\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"2000-07-16\",\r\n" + "  \"emp_status\": \"Worker\",\r\n"
						+ "  \"emp_job_title\": \"Developer\"\r\n" + "}")
				.log().all();

		/**
		 * Storing response into reference variable
		 */

		Response createEmployeeResponse = createEmployeeRequest.when().post("createEmployee.php");

		/**
		 * print the response with pretty Print()
		 */

		createEmployeeResponse.prettyPrint();

		/**
		 * jsonPath() to view response body which let us get the employee ID
		 */

		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		/**
		 * optional to print employee ID
		 */
		System.out.println("employeeID = " + employeeID);

		/**
		 * verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * verifying message using equalTo() method -manually imported import static
		 * org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/**
		 * verifying message that body has emp_fistname equals to "string". Employee[0]
		 * used to reach all information of employee
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("string"));

		/**
		 * verifying message that header has server of Apache/2.4.39 (Win64) PHP/7.2.18
		 * DONT USE assertThat()
		 */

		createEmployeeResponse.then().header("server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));

		/**
		 * verifying that Content-Type is application/json
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", equalTo("application/json"));

	}

	@Test
	public void bGETcreatedEmployee() {

		/**
		 * Preparing request for /getOneEmployee.php using given().
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		getCreatedEmployeeRequest.then().statusCode(200);

		/**
		 * making call to retrieve created employee using when().
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * to print response prettyPrint() method converts JSON object into
		 */
		String response = getCreatedEmployeeResponse.prettyPrint();

		/**
		 * JsonPath() used to view response body and return String storing response
		 * employeeID into empID which will be used for verification against stored
		 * global employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		boolean verifyingEmployee_IDsMatch = empID.equalsIgnoreCase(employeeID);
		System.out.println("Employee ID's match: " + verifyingEmployee_IDsMatch);
		/**
		 * Asserting employee ID's match
		 */
		Assert.assertTrue(verifyingEmployee_IDsMatch);

		getCreatedEmployeeResponse.then().statusCode(200);

		JsonPath js = new JsonPath(response); // this response argument comes from line 174

		/**
		 * in getCreated, body starts with employee and only one employee displayed
		 * thats why [0]
		 */
		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String bday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID + " " + firstName + " " + middleName + " " + lastName + " " + bday + " " + gender
				+ " " + jobTitle + " " + empStatus);

		/**
		 * verifying emplyee id's match
		 */
		Assert.assertTrue(emplID.contentEquals(employeeID));
		Assert.assertEquals(employeeID, emplID);

		/** Verifying expected first name matches actual first name */
		Assert.assertTrue(firstName.contentEquals("string"));

		/** Verifying expected middle name matches actual middle name */
		Assert.assertTrue(middleName.contentEquals("ziya"));

		/** Verifying expected last name matches actual last name */
		Assert.assertTrue(lastName.contentEquals("string"));

		/** Verifying expected birth date matches actual birth date */
		Assert.assertTrue(bday.contentEquals("2000-07-16"));

		/** Verifying expected gender matches actual gender */
		Assert.assertTrue(gender.contentEquals("Female"));

		/** Verifying expected job title matches expected job title */
		Assert.assertTrue(jobTitle.contentEquals("Developer"));

		/** Verifying expected employee status matches actual employee status */
		Assert.assertTrue(empStatus.contentEquals("Worker"));
	}

	@Test
	public void cGETallEmployees() {

		/**
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/**
		 * Storing response into reference variable
		 */
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/**
		 * printing all employees
		 */
		// getAllEmployeesResponse.prettyPrint();

		String allEmployees = getAllEmployeesResponse.body().asString();

		/**
		 * the below will pass but inccorrect cause only emp_id will be checked not rest
		 * of it
		 */
		allEmployees.contains(employeeID);

		/**
		 * -------------DO RESEARCH-----------------
		 */
		allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		/**
		 * Retrieving size of Employees list
		 */
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);

		/**
		 * print out all employee ID's
		 */
//
//		for (int i = 0; i < sizeOfList; i++) {
//
//			/**
//			 * printing all employee IDs
//			 */
//
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//			//System.out.println(allEmployeeIDs);
//			
//			/**
//			 * if statement inside for loop to find stored employee ID and break the loop
//			 * we found
//			 */
//			
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee ID: " +employeeID + "is present in body");
//				
//				/**
//				 * printing all employees firstNAme
//				 */
//				String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//				
//				break;
//			}
//		}

	}

	@Test
	public void dPUTupdateCreatedEmployee() {

		/**
		 * Preparing request to update created employee calling static method
		 * updateCtreatedEmpBody() from HardcodedConstants class
		 */

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmpBody());

		/**
		 * Storing response into updateCreatedEmployeeResponse
		 */
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/**
		 * Storing response into a String
		 */
//		String response = updateCreatedEmployeeResponse.prettyPrint();
//		System.out.println(response);

		/**
		 * Asserting using hamcrest matchers equalTo() method to verify employee is
		 * updated
		 */
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
//		
		/**
		 * Retrieving response body employee ID using jsontPath()
		 */
		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		/**
		 * Asserting that response body employee ID matches globally stored employee ID
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));

	}

	@Test
	public void eGETUpdatedEmployee() {

		/**
		 * Preparing request to get updated employee
		 */
		RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);

		/**
		 * Storing response into getUpdatedEmployeeResponse
		 */
		Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Printing response
		 */
		// getUpdatedEmployeeResponse.prettyPrint();

		/**
		 * Asserting expected first name
		 */
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_middle_name", equalTo("mistik"));

		/**
		 * Verifying response employee ID is equal to globally stored employee ID
		 */
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));

	}

	@Test
	public void fPATCHpartiallyUpdateEmployee() {

		RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\n" + "  \"employee_id\": \"" + employeeID + "\",\n"
						+ "  \"emp_firstname\": \"tosun\"\n" + "}");

		Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when()
				.patch("/updatePartialEmplyeesDetails.php");

		// partiallyUpdatingEmployeeResponse.prettyPrint();

		partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);

		partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));

	}

	@Test
	public void gDELETEemployee() {

		RequestSpecification deleteEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);

		Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");

		deleteEmployeeResponse.prettyPrint();

		deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));

	}

}
