Feature: Login with valid credentials in demo blaze site 
@InvalidCredentials
 Scenario Outline: Login with valid credentials in demo blaze site
 
 Given the user is on demoblaze Login page
 When user enters valid credentials
    | Admin | admin |
 And user clicks the login button in demoblaze site
 Then user should be able to login successfully in deomblaze site
 