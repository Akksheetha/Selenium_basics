package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	@Given("User is on Home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Step1");
	}

	@When("user enters userName as {string}")
	public void user_enters_user_name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step2");
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step3");
	}

	@Then("user should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step4");
	}

}
