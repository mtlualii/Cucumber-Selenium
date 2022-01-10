package com.vytrack.step_definitions;

import com.vytrack.Pages.ContactsPage;
import com.vytrack.Pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationStepDefs {

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("1.1");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("1.2");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("2.1");
    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("2.2");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("3.1");
    }

    @Then("the title should be Calendars")
    public void the_title_should_be_Calendars() {
        System.out.println("3.2");
    }

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {

        new DashboardPage().navigateToModule(tab, module);
        BrowserUtils.waitFor(3);
    }

    @Then("default page should be {int}")
    public void default_page_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(3);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum, actualNumber);

    }


}
