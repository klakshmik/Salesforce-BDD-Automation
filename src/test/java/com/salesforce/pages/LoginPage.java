package com.salesforce.pages;

import com.salesforce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "Login")
    public WebElement loginButton;

}

