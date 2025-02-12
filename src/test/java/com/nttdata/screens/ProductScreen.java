package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;

    @AndroidFindBy(accessibility = "App logo and name")
    private WebElement sortingOrder;

    public boolean isProductsTitleVisible() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(productsTitle));
        return productsTitle.isDisplayed(); //isEnabled();
    }

    public boolean isSortingOrderVisible() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(sortingOrder));
        return sortingOrder.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='{0}']")
    private WebElement productByName;

    public void selectProduct(String productName) {
        try {
            WebElement product = findBy("//android.widget.ImageView[@content-desc='" + productName + "']");

            // Esperar que el producto esté visible y sea clickeable
            withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOf(product));
            withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.elementToBeClickable(product));

            product.click();

        } catch (NoSuchElementException e) {
            throw new AssertionError("ERROR: No se encontró el producto '" + productName + "' en la galería.");
        }
    }
}
// Se simplifico este codigo, Julio Bendezu
/*    public void selectProduct(String productName) {
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
    }*/