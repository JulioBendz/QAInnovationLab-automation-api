package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProductScreen {

    public ProductScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private MobileElement productsTitle;

    @AndroidFindBy(accessibility = "Sauce Labs Backpack")
    private MobileElement backpackProduct;

    @AndroidFindBy(accessibility = "Sauce Labs Bolt T-Shirt")
    private MobileElement tshirtProduct;

    @AndroidFindBy(accessibility = "Sauce Labs Bike Light")
    private MobileElement bikeLightProduct;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private MobileElement cartButton;

    public boolean isProductsTitleVisible() {
        return productsTitle.isDisplayed();
    }

    public void selectProduct(String productName) {
        switch (productName) {
            case "Sauce Labs Backpack":
                backpackProduct.click();
                break;
            case "Sauce Labs Bolt - T-Shirt":
                tshirtProduct.click();
                break;
            case "Sauce Labs Bike Light":
                bikeLightProduct.click();
                break;
            default:
                throw new IllegalArgumentException("Producto no encontrado: " + productName);
        }
    }

    public void goToCart() {
        cartButton.click();
    }
}