package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest1 {
    @Test(priority = 2, groups = {"regresion"})
    //@Test(enabled = false) - pentru omiterea testului
    public void login() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password!");

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        WebElement alertMessage = driver.findElement(By.id("flash"));
        String alertText = "Your password is invalid!";
        Assert.assertTrue(alertMessage.getText().contains(alertText));

        String loginUrl = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(loginUrl,driver.getCurrentUrl());

        driver.close();
    }
}
