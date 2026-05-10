Feature: Login with invalid credentials in demoblaze 
@InvalidCredentials
 Scenario Outline: Login with invalid credentials in demoblaze
 
Given the user is on demoblaze1 Login page
 When user enters invalid credentials with multiple
    | Admin1   | admin1     | Wrong password.                          |
    |          | wrong_pass | Please fill out Username and Password.   |
    | @*       |            | Please fill out Username and Password.   |
 And user clicks the login button in demoblaze1 site
 Then user should be able to login successfully in deomblaze site1