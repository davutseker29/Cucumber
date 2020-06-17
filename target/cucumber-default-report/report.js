$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SauceDemoLoginwithDataTable.feature");
formatter.feature({
  "name": "Sauce Demo login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "invalid login",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter invalid username as below",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user enter invalid password",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.SauceDemoLoginSteps.user_enter_invalid_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.SauceDemoLoginSteps.click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user should see the error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.SauceDemoLoginSteps.user_should_see_the_error_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "invalid login");
formatter.after({
  "status": "passed"
});
});