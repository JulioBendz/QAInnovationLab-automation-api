package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import com.nttdata.screens.ProductDetailsScreen;
import com.nttdata.screens.ProductScreen;
import org.junit.Assert;

public class CartSteps {

    ProductScreen productScreen;
    ProductDetailsScreen productDetailsScreen;
    CartScreen cartScreen;

    public void estoyEnLaAplicacionDeSauceLabs() {
        Assert.assertTrue("La aplicación no se cargó correctamente", productScreen.isProductsTitleVisible());
    }

    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        Assert.assertTrue("Los productos no se cargaron correctamente :(", productScreen.isSortingOrderVisible());
    }

    public void agregoDelSiguienteProducto(int unidades, String producto) {
        productScreen.selectProduct(producto);
        if (unidades > 1) {
            productDetailsScreen.increaseQuantity(unidades);
        }
        productDetailsScreen.addToCart();
    }

    public void validoElCarritoDeCompraActualiceCorrectamente() {
        productDetailsScreen.goToCart();
        String productName = cartScreen.getProductNameInCart();
        int quantity = cartScreen.getProductQuantityInCart();
        Assert.assertTrue("El nombre del producto en el carrito no coincide", productName.contains("Sauce Labs"));
        Assert.assertTrue("La cantidad del producto en el carrito no coincide", quantity >= 1);
    }
}