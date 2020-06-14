package com.hrms.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeePersonalDetailsSteps extends CommonMethods {

	@Given("User wants to log in HRMS page")
	public void user_wants_to_log_in_HRMS_page() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@When("User logged in with valid admin credential")
	public void user_logged_in_with_valid_admin_credential() {
		String expected = "Welcome Admin";
		String actual = dashboard.welcome.getText();
		Assert.assertEquals("Welcome message is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}

	@When("User clicks the PIM dropdown")
	public void user_clicks_the_PIM_dropdown() {

		jsClick(dashboard.PIM);
	}

	@When("User clicks the Employee List")
	public void user_clicks_the_Employee_List() {
		jsClick(dashboard.empListPage);
	}

	@When("User navigated to Employee List page")
	public void user_navigated_to_Employee_List_page() {

		String expected = "Employment Status";
		String actual = viewEmp.pageTitle.getText();
		Assert.assertEquals("Employee Information is not displayed or not correct ", expected, actual);
		System.out.println(actual);

	}

	@When("User enters valid employee Id {string}")
	public void user_enters_valid_employee_Id(String empId) {
		sendText(viewEmp.empID, empId);
	}

	@When("User clicks the search button")
	public void user_clicks_the_search_button() {

		jsClick(viewEmp.searchBtn);
		wait(2);
	}

	@When("User clicks the displayedd id")
	public void user_clicks_the_displayed_id() {

		click(driver.findElement(By.xpath("//a[text()='14063']")));
		wait(3);
	}

	@Then("User navigated to Personal Detail Page")
	public void user_navigated_to_Personal_Detail_Page() {

		String expected = "Personal Details";
		String actual = pdetails.lblPersonalDetails.getText();
		Assert.assertEquals("Personal Details not displayed", expected, actual);
		System.out.println(actual);
	}
	@Then("User click the Edit button")
	public void user_click_the_Edit_button() {
		
		click(pdetails.editBtn);
	   
	}

	@When("clear the firstName and lastName")
	public void clear_the_firstName_and_lastName() {

		pdetails.firstName.clear();
		pdetails.lastName.clear();
		
		sendText(pdetails.firstName,"Yusuf");
		sendText(pdetails.lastName,"Yazici");
		
	}

	@When("User types the Driver License Number")
	public void user_types_the_Driver_License_Number() {
		sendText(pdetails.driverLicNo,"09823402498rd");
	}

	@When("User modify License expiry date")
	public void user_modify_License_expiry_date() {
		
		sendText(driver.findElement(By.id("personal_txtLicExpDate")),"2024-Apr-04");
	}

	@When("User types the SSN numer")
	public void user_types_the_SSN_numer() {
		
		sendText(pdetails.SSNNo,"323-243-3443");
	}

	@When("User selects the gender")
	public void user_selects_the_gender() {
		
		click(driver.findElement(By.id("personal_optGender_1")));
		wait(4);
	}

	@When("User selects the nationality")
	public void user_selects_the_nationality() {
		
		selectDdValue(pdetails.nationalityDD, "Turkish");
	}

	@Then("User clicks the Save button")
	public void user_clicks_the_Save_button() {
		click(pdetails.btnSave);
		
	}

}
