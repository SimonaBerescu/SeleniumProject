package com.pageobjectmodel.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    private void setUp() {
        //1.open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/");
    }
}
