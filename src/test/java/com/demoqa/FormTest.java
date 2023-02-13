package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {
    private WebDriver driver;
    @BeforeMethod
    private void setUp() {
        //1.open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }
    @Test
    private void formTest(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Simona");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Berescu");
        WebElement email = driver.findElement((By.id("userEmail")));
        email.sendKeys("simona_gorgos@yahoo.com");
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        gender.click();

        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys("0730441080");
        WebElement dateOfBrith = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBrith.click();
        WebElement month = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("0");
        WebElement year = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1992");
        WebElement day = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[4]"));
        day.click();

        WebElement subjects = driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]"));
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement hobbiesMusic = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
        hobbiesMusic.click();
        WebElement hobbiesReading = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
        hobbiesReading.click();
        WebElement picture = driver.findElement(By.id("uploadPicture"));
        picture.sendKeys("C:\\Users\\Bubus\\IdeaProjects\\SeleniumProject\\src\\test\\resources\\hummingbird (1).jpg");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Strada Horea 80, Cluj-Napoca");

       // WebElement state = driver.findElement(By.xpath("//*[@id=\"react-select-3-option-0\"]"));
        //state.click();

        //WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]"));
       // city.sendKeys("Delhi");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.sendKeys(Keys.ENTER);

        WebElement finalMessage = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String alertText = "Thanks for submitting the form";
        Assert.assertTrue(finalMessage.getText().contains(alertText));
    }

    @AfterMethod
    private void tearDown() {
        //5.Close window
        driver.close();
    }
}
