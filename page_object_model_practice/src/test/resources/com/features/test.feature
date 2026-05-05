Feature: Login to HRM Application

 @ValidCredentials
 Scenario: Login with valid credentials
 
 Given User is on Home page
 When user enters userName as "Admin"
 And user enters password as "admin123"
 Then user should be able to login successfully