package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartScreen extends PageObject {


    @AndroidFindBy(accessibility = "Displays selected product")
    //si no funciona probar con xpath de la letra del producto: com.saucelabs.mydemoapp.android:id/titleTV
    private WebElement productInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/quantityTV")
    //com.saucelabs.mydemoapp.android:id/noTV (si no funciona probar con noTV en lugar de quantityTV)
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