package com.demoblaze.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("The user navigates to website")
    public void the_user_navigates_to_website() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user clicks on login button and enters valid credentials")
    public void the_user_clicks_on_login_button_and_enters_valid_credentials() {
        loginPage.login();
    }

    @Then("The user verifies that welcome message is displayed")
    public void the_user_verifies_that_welcome_message_is_displayed() {
        homePage.verifyWelcomeMessage();
    }

    @When("The user clicks on login button and enters {string} and {string}")
    public void the_user_clicks_on_login_button_and_enters_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user verifies that welcome {string} is displayed")
    public void the_user_verifies_that_welcome_is_displayed(String username) {
        homePage.verifyWelcomeMessage(username);
    }
}
