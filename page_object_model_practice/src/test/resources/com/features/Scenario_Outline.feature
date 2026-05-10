Feature: Login with invalid credentials 
@InvalidCredentials
 Scenario Outline: Login with invalid credentials
 
 Given the user is on Login page
 When user enters UserName as "<username>"
 And user enters Password as "<password>"
 And user clicks the login button
 Then popup "<errorMessage>" should be displayed successfully
 
  Examples:

      | username | password   | errorMessage                             |
      | Admin1   | admin1     | Wrong password.                          |
      |          | wrong_pass | Please fill out Username and Password.   |
      | @*       |            | Please fill out Username and Password.   |