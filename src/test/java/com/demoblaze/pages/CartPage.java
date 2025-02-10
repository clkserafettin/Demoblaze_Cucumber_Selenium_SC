package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.util.Arrays;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement l_placeOrder_btn;
    @FindBy(id = "name")
    public WebElement l_name;
    @FindBy(id = "country")
    public WebElement l_country;
    @FindBy(id = "city")
    public WebElement l_city;
    @FindBy(id = "card")
    public WebElement l_card;
    @FindBy(id = "month")
    public WebElement l_month;
    @FindBy(id = "year")
    public WebElement l_year;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement l_purchaseBtn;


    public int removeProduct(String product) {
        l_cartBtn.click();
        String productPath = "//td[.='" + product + "']";


        String productPricePath = productPath + "/../td[3]";


        String deletePath = productPricePath + "/../td[a]/a";

        //** NOT OLARAK EKLE**
        //get the price text of the deleted element
        String priceText = Driver.get().findElement(By.xpath(productPricePath)).getText();
        System.out.println("priceText = " + priceText);
        //delete product
        Driver.get().findElement(By.xpath(deletePath)).click();
        //sayfa kendine gelsin diye
        BrowserUtils.waitForVisibility(By.xpath(productPath), 10);

        return Integer.parseInt(priceText);
    }

    public void fillForm() {
        faker = new Faker();
        BrowserUtils.waitFor(1);
        l_name.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        l_country.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        l_city.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        l_card.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        l_month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        BrowserUtils.waitFor(1);
        l_year.sendKeys(String.valueOf(faker.number().numberBetween(2024, 2030)));
        BrowserUtils.waitFor(1);
    }

    @FindBy(css = "[class=\"lead text-muted \"]")
    public WebElement l_confirmation;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement l_okBtn;

    int actualAmount;

    public void finishPurchase() {
        BrowserUtils.waitFor(2);
        l_placeOrder_btn.click();


        fillForm();
        l_purchaseBtn.click();
        String confirmationText = l_confirmation.getText();
        System.out.println("confirmationText = " + confirmationText);

        //Id: 2432207
        //Amount: 4600 USD
        //Card Number: 6771105073822968
        //Name: Ms. Harold Gutmann
        //Date: 29/0/2025
        String[] confirmationArray = confirmationText.split("\n");

        //Amount: 4600 USD
        actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);    // ==> 4600
        System.out.println("actualAmount = " + actualAmount);
        BrowserUtils.waitFor(1);

        l_okBtn.click();

    }

    public void verifyPurchaseAmount(int expectedPurchaseAmount) {
        Assert.assertEquals(expectedPurchaseAmount, actualAmount);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
        System.out.println("actualAmount = " + actualAmount);
    }
}
