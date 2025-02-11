package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsScreen extends PageObject {

    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "Displays number of items in your cart")
    private WebElement cartButton;

    public void increaseQuantity(int units) {
        for (int i = 1; i < units; i++) {
            waitFor(ExpectedConditions.elementToBeClickable(increaseQuantityButton));
            increaseQuantityButton.click();
        }
    }

    public void addToCart() {
        waitFor(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void goToCart() {
        waitFor(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }
}