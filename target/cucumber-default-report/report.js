$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/EmployeePersonalDetails.feature");
formatter.feature({
  "name": "EmployeePersonalDetails",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Modify Employee Personal Details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User wants to log in HRMS page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_wants_to_log_in_HRMS_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logged in with valid admin credential",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_logged_in_with_valid_admin_credential()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the PIM dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_clicks_the_PIM_dropdown()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the Employee List",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_clicks_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigated to Employee List page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_navigated_to_Employee_List_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters valid employee Id \"14063\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_enters_valid_employee_Id(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the search button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_clicks_the_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the displayedd id",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_clicks_the_displayed_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigated to Personal Detail Page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_navigated_to_Personal_Detail_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clear the firstName and lastName",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.clear_the_firstName_and_lastName()"
});
formatter.result({
  "error_message": "org.openqa.selenium.InvalidElementStateException: invalid element state: Element is not currently interactable and may not be manipulated\n  (Session info: chrome\u003d83.0.4103.97)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DAVID\u0027, ip: \u0027192.168.0.218\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\User\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:60576}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 0c3fc08d6868e5bb474dd6993d6bfd88\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.clear(RemoteWebElement.java:124)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:567)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy19.clear(Unknown Source)\r\n\tat com.hrms.steps.EmployeePersonalDetailsSteps.clear_the_firstName_and_lastName(EmployeePersonalDetailsSteps.java:82)\r\n\tat ✽.clear the firstName and lastName(file:///C:/Users/User/eclipse-workspace/Hrms/src/test/resources/features/EmployeePersonalDetails.feature:14)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User types the Driver License Number",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_types_the_Driver_License_Number()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User modify License expiry date",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_modify_License_expiry_date()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User types the SSN numer",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_types_the_SSN_numer()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects the gender",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_selects_the_gender()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects the nationality",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_selects_the_nationality()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks the Edit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeePersonalDetailsSteps.user_clicks_the_Edit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "Modify Employee Personal Details");
formatter.after({
  "status": "passed"
});
});