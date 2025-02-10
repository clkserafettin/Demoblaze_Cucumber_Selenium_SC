package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class HomePage extends BasePage {

    @FindBy(linkText = "Add to cart")
    private WebElement l_addToCartBtn;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement l_priceText;

    public void verifyWelcomeMessage() {
        BrowserUtils.waitForVisibility(l_nameOfUser, 5);
        String actualMsg = l_nameOfUser.getText();
        Assert.assertTrue(actualMsg.contains(ConfigurationReader.get("username")));
    }

    public void verifyWelcomeMessage(String username) {
        BrowserUtils.waitForVisibility(l_nameOfUser, 5);
        String actualMsg = l_nameOfUser.getText();
        Assert.assertTrue(actualMsg.contains(username));
    }

    public int addProduct(String product, String category) {
        try {
            WebElement categoryTab = Driver.get().findElement(By.linkText(category));
            BrowserUtils.waitForClickablility(categoryTab, 5).click();
        } catch (Exception e) {
            BrowserUtils.waitForClickablility(By.linkText(category), 5).click();
        }

        try {
            WebElement productTitle = Driver.get().findElement(By.linkText(product));
            BrowserUtils.waitForClickablility(productTitle, 5).click();
        } catch (Exception e) {
            BrowserUtils.waitForClickablility(By.linkText(product), 5).click();
        }


        System.out.println("l_priceText.getText() = " + l_priceText.getText());
        String[] arrayAmount = l_priceText.getText().split(" ");
        System.out.println("Arrays.toString(arrayAmount) = " + Arrays.toString(arrayAmount));

        int lastPrice = Integer.parseInt(arrayAmount[0].substring(1));
        System.out.println("lastPrice = " + lastPrice);


        l_addToCartBtn.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = Driver.get().switchTo().alert();
        alert.accept();

        l_homeBtn.click();

        return lastPrice;
    }
}
