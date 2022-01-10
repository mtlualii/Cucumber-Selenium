package com.vytrack.step_definitions;

import com.vytrack.Pages.BasePage;
import com.vytrack.Pages.DashboardPage;
import com.vytrack.Pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(3);
        //get the list of webelements and conver them to list o String and assert with expected ones

        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println(userInfo);
        // task: use map information to login and also verify firstname and lastname

        //login with map info
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));

        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname")+" "+userInfo.get("lastname");

        Assert.assertEquals(actualName,expectedName);




    }


}
