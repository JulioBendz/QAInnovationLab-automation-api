package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;

    public boolean isProductsTitleVisible() {
        waitFor(ExpectedConditions.visibilityOf(productsTitle));
        return productsTitle.isDisplayed();
    }

    @AndroidFindBy(accessibility = "Sauce Labs Backpack")
    private WebElement backpackProduct;

    @AndroidFindBy(accessibility = "Sauce Labs Bolt T-Shirt")
    private WebElement tshirtProduct;

    @AndroidFindBy(accessibility = "Sauce Labs Bike Light")
    private WebElement bikeLightProduct;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartButton;

    public void selectProduct(String productName) {
        switch (productName) {
            case "Sauce Labs Backpack":
                waitFor(ExpectedConditions.elementToBeClickable(backpackProduct));
                backpackProduct.click();
                break;
            case "Sauce Labs Bolt - T-Shirt":
                waitFor(ExpectedConditions.elementToBeClickable(tshirtProduct));
                tshirtProduct.click();
                break;
            case "Sauce Labs Bike Light":
                waitFor(ExpectedConditions.elementToBeClickable(bikeLightProduct));
                bikeLightProduct.click();
                break;
            default:
                throw new IllegalArgumentException("Producto no encontrado: " + productName);
        }
    }

    public void goToCart() {
        waitFor(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }
}