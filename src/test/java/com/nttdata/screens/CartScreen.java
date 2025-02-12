package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CartScreen extends PageObject {


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
    //si no funciona probar con id de la letra del producto: com.saucelabs.mydemoapp.android:id/titleTV
    private WebElement productInCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    //si no funciona con el xpath probar con el id: com.saucelabs.mydemoapp.android:id/noTV
    private WebElement quantityInCart;

    public String getProductNameInCart() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(productInCart));
        return productInCart.getText();
    }

    public int getProductQuantityInCart() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.visibilityOf(quantityInCart));
        return Integer.parseInt(quantityInCart.getText());
    }
}