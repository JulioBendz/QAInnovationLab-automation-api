package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductDetailsScreen extends PageObject {

    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "Displays number of items in your cart")
    private WebElement cartButton;

    public void increaseQuantity(int units) {
        for (int i = 1; i < units; i++) {
            withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(increaseQuantityButton));
            increaseQuantityButton.click();
        }
    }

    public void addToCart() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void goToCart() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();
    }

    public boolean isProductDetailsVisible() {
        try {
            WebElement productTitle = findBy("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV']");
            withTimeoutOf(Duration.ofSeconds(5)).waitFor(ExpectedConditions.visibilityOf(productTitle));
            return productTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}