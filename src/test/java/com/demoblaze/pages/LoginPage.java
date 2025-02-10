package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "loginusername")
    private WebElement l_usernameBox;

    @FindBy(id = "loginpassword")
    private WebElement l_passwordBox;

    @FindBy(xpath = "//button[.='Log in']")
    private WebElement l_loginBtn2;

    public void login() {
        l_loginBtn.click();
        l_usernameBox.sendKeys(ConfigurationReader.get("username"));
        l_passwordBox.sendKeys(ConfigurationReader.get("password"));
        l_loginBtn2.click();
    }

    public void login(String username, String password) {
        l_loginBtn.click();
        l_usernameBox.sendKeys(username);
        l_passwordBox.sendKeys(password);
        l_loginBtn2.click();
    }
}
