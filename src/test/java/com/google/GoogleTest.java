package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class GoogleTest {
    @Test
    public void testGoogle(){
        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open page
        String url = "https://www.google.com/";
        driver.get(url);
        System.out.println("Page opens");

        //maximize browser window
        driver.manage().window().maximize();
        System.out.println("Page is maximized");

        Assert.assertEquals(url,driver.getCurrentUrl());

        //close page
        driver.quit();
        System.out.println("Page closes");
    }
}
