package com.vytrack.step_definitions;

import com.vytrack.Pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.security.auth.login.Configuration;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        WebDriver driver = Driver.get();
        Driver.get().get(url); // first 'get' reach "driver", second 'get' open the internet page
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);

    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {

        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));

    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("salesmanager_username");
            password = ConfigurationReader.get("salesmanager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("storemanager_username");
            password = ConfigurationReader.get("storemanager_password");
        }

        new LoginPage().login(username,password);
    }

}
