package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResgitrasiSteps  {

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        System.out.println("tes1");
    }
    @When("I enter valid username {string} and email {string}")
    public void i_enter_valid_username_and_email(String string, String string2) {
        System.out.println("tes2");
    }
    @And("I enter a valid password {string}")
    public void i_enter_a_valid_password(String string) {
        System.out.println("tes3");
    }
    @And("I confirm the password {string}")
    public void i_confirm_the_password(String string) {
        System.out.println("tes4");
    }
    @And("I click the register button")
    public void i_click_the_register_button() {
        System.out.println("tes5");
    }
    @Then("I should see a welcome message")
    public void i_should_see_a_welcome_message() {
        System.out.println("tes6");
    }


}
