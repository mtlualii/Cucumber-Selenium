package com.vytrack.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {


    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

}



