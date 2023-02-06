package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    @BeforeMethod
    private void setUp(){
        //1.open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @Parameters({"user","password"})
    @Test(priority = 1, groups = {"smoke","regresion"})
    public void login(String user, String password) {


        //2.enter username & password
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        //3.press login button
        //by class name
        // WebElement loginButton = driver.findElement(By.className("radius"));
        //by xpath
        // WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        //by cssSelector
        WebElement loginButton = driver.findElement(By.cssSelector("i.fa-sign-in"));
        loginButton.click();

        //4.verification
        String landingUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(landingUrl,"https://the-internet.herokuapp.com/secure");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement alert = driver.findElement(By.id("flash"));
        String alertText = "You logged into a secure area!";
        Assert.assertTrue(alert.isDisplayed());
        Assert.assertTrue(alert.getText().contains(alertText));

    }
    @Test(priority = 2, groups = {"regresion"})
    //@Test(enabled = false) - pentru omiterea testului
    public void login() {

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

    }
    @AfterMethod
    private void tearDown(){
        //5.Close window
        driver.close();
    }

}
