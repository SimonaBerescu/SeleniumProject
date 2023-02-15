package com.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public final static String LOGIN_URL = BASE_URL+"login";
    @FindBy(id="username")
    public WebElement usernameInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(className = "radius")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterPassword(){
        passwordInput.sendKeys("SuperSecretPassword!");
    }
    public void enterUsername(){
        usernameInput.sendKeys("tomsmith");
    }
    public void setLoginButton(){
        loginButton.click();

    }
}
