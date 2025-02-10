package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    int expectedPurchaseAmount = 0;

    @When("The user adds {string} product from {string} category")
    public void the_user_adds_product_from_category(String product, String category) {
        expectedPurchaseAmount += homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

    @When("The user removes {string} from cart page")
    public void the_user_removes_from_cart_page(String product) {
        expectedPurchaseAmount -= cartPage.removeProduct(product);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }

    @When("The user place order and capture log amount")
    public void the_user_place_order_and_capture_log_amount() {
        cartPage.finishPurchase();
    }

    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPage.verifyPurchaseAmount(expectedPurchaseAmount);
    }
}
