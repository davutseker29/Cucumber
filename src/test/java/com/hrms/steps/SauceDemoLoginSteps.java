package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginSteps extends CommonMethods {

	@When("user enter invalid username")
	public void user_enter_invalid_username() {
		sendText(sdemologin.userName, "asdasdasd");

	}

	@When("user enter invalid password")
	public void user_enter_invalid_password() {
		sendText(sdemologin.password, "wer");
		wait(2);
	}

	@When("click on login button")
	public void click_on_login_button() {
		click(sdemologin.LoginBTN);
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {

		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = sdemologin.errorMessage.getText();

		Assert.assertEquals("Error is not displayed", expected, actual);

	}
	@When("user enter invalid username as {string}")
	public void user_enter_invalid_username_as(String userName) {
	   sendText(sdemologin.userName,userName);
	}

	@When("user enter invalid password as {string}")
	public void user_enter_invalid_password_as(String password) {
	   sendText(sdemologin.password,password);
	}
	
	@When("user enter invalid username as below")
	public void user_enter_invalid_username_as_below(DataTable dataTable) {
	 List<Map<String, String>> data = dataTable.asMaps(); 
	 for (Map<String, String> map : data) {
	System.err.println(map.get("username"));
	dataTable.asList().get(0);// if i have only 1 value
	
	
	}
	 
	 
	 
}
}