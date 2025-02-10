package com.demoblaze.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demoblaze.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    protected Alert alert;

    protected Faker faker;

    protected WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    @FindBy(id = "login2")
    public WebElement l_loginBtn;

    @FindBy(id = "nameofuser")
    public WebElement l_nameOfUser;

    @FindBy(partialLinkText = "Home")
    public WebElement l_homeBtn;

    @FindBy(linkText = "Cart")
    public WebElement l_cartBtn;

}
