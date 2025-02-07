package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProductDetailsScreen {

    public ProductDetailsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Increase item quantity")
    private MobileElement increaseQuantityButton;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private MobileElement addToCartButton;

    public void increaseQuantity(int units) {
        for (int i = 1; i < units; i++) {
            increaseQuantityButton.click();
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }
}