package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import com.nttdata.screens.ProductDetailsScreen;
import com.nttdata.screens.ProductScreen;
import static org.junit.Assert.assertTrue;

public class CartSteps {

    private final ProductScreen productScreen;
    private final ProductDetailsScreen productDetailsScreen;
    private final CartScreen cartScreen;

    public CartSteps() {
        this.productScreen = new ProductScreen();
        this.productDetailsScreen = new ProductDetailsScreen();
        this.cartScreen = new CartScreen();
    }

    public void estoyEnLaAplicacionDeSauceLabs() {
        assertTrue("La aplicación no se cargó correctamente", productScreen.isProductsTitleVisible());
    }

    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        assertTrue("Los productos no se cargaron correctamente", productScreen.isProductsTitleVisible());
    }

    public void agregoDelSiguienteProducto(int unidades, String producto) {
        productScreen.selectProduct(producto);
        if (unidades > 1) {
            productDetailsScreen.increaseQuantity(unidades);
        }
        productDetailsScreen.addToCart();
    }

    public void validoElCarritoDeCompraActualiceCorrectamente() {
        productScreen.goToCart();
        String productName = cartScreen.getProductNameInCart();
        int quantity = cartScreen.getProductQuantityInCart();
        assertTrue("El nombre del producto en el carrito no coincide", productName.contains("Sauce Labs"));
        assertTrue("La cantidad del producto en el carrito no coincide", quantity >= 1);
    }
}