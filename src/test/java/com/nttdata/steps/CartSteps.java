package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import com.nttdata.screens.ProductDetailsScreen;
import com.nttdata.screens.ProductScreen;
import net.thucydides.core.annotations.Step;
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

    @Step("Estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        assertTrue("La aplicación no se cargó correctamente", productScreen.isProductsTitleVisible());
    }

    @Step("Valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        assertTrue("Los productos no se cargaron correctamente", productScreen.isProductsTitleVisible());
    }

    @Step("Agrego {0} del siguiente producto {1}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        productScreen.selectProduct(producto);
        if (unidades > 1) {
            productDetailsScreen.increaseQuantity(unidades);
        }
        productDetailsScreen.addToCart();
    }

    @Step("Valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        productScreen.goToCart();
        String productName = cartScreen.getProductNameInCart();
        int quantity = cartScreen.getProductQuantityInCart();

        assertTrue("El nombre del producto en el carrito no coincide", productName.contains("Sauce Labs"));
        assertTrue("La cantidad del producto en el carrito no coincide", quantity >= 1);
    }
}