package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    private WebDriver driver;
    @BeforeMethod
    private void setUp() {
        //1.open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
    }
    @Test
    private void fileUploadTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\Bubus\\IdeaProjects\\SeleniumProject\\src\\test\\resources\\hummingbird (1).jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String textMessge = "File Uploaded!";
        Assert.assertEquals(fileUploadedMessage.getText(),textMessge);
    }

    @AfterMethod
    private void tearDown() {
        //5.Close window
        driver.close();
    }

}
