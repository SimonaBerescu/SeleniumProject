package com.pageobjectmodel.pages;

import com.pageobjectmodel.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    final static String baseUrl = "https://the-internet.herokuapp.com/";

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
