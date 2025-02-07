package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CartScreen {

    public CartScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Displays selected product")
    private MobileElement productInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/quantityTV")
    private MobileElement quantityInCart;

    public String getProductNameInCart() {
        return productInCart.getText();
    }

    public int getProductQuantityInCart() {
        return Integer.parseInt(quantityInCart.getText());
    }
}