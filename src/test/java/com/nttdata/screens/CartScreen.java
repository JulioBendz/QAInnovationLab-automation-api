package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartScreen extends PageObject {


    @AndroidFindBy(accessibility = "Displays selected product")
    private WebElement productInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/quantityTV")
    private WebElement quantityInCart;

    public String getProductNameInCart() {
        waitFor(ExpectedConditions.visibilityOf(productInCart));
        return productInCart.getText();
    }

    public int getProductQuantityInCart() {
        waitFor(ExpectedConditions.visibilityOf(quantityInCart));
        return Integer.parseInt(quantityInCart.getText());
    }
}