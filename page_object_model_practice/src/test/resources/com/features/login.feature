Feature: Login to DemoBlaze site

 Background:
  Given user is on login page

 @ValidCredentials
 Scenario: Login with valid credentials
 
 When user enters userName as "Admin"
 And user enters password as "admin"
 And clicks Login button
 Then user should be able to login successfully
 
  @InvalidCredentials
 Scenario: Login with invalid credentials
 
 When user tries to login with invalid credentials
 And clicks the login button
 Then popup message should be displayed successfully
 
 
 @BlankCredentials
 Scenario: Login without credentials
 
 When user tries to login without filling the credentials
 And click the login button
 Then popup message should be displayed successfully