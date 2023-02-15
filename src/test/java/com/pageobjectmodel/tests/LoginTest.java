package com.pageobjectmodel.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.pageobjectmodel.pages.LoginPage.LOGIN_URL;

public class LoginTest extends BaseTest{
    @Test
    public void positiveLogin() {
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
    }
}
