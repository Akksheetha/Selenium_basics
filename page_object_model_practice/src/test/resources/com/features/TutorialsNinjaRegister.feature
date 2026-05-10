Feature: Registreing into the TutorialsNinja Page 

@Register
Scenario: Registering with credentials in tutorials Ninja 

Given the user is on register page
When the user enters personal details
  | firstname | lastname | email          | telephone |
  | Akkshee   | M        | abc@gmail.com  | 1234567890 |
And the user enters password details
  | password     | confirmPassword |
  | Password@123 | Password@123    |
And clicks the continue button
Then the user should be redirected to the page successfully