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
        Assert.assertTrue("La aplicación no se cargó correctamente", productScreen.isSortingOrderVisible());
    }

    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        Assert.assertTrue("Los productos no se cargaron correctamente :(", productScreen.isProductsTitleVisible());
    }

    public void agregoDelSiguienteProducto(int unidades, String producto) {
        productScreen.selectProduct(producto);

        // 🔹 Verificar que la pantalla de detalles del producto se haya cargado
        if (!productDetailsScreen.isProductDetailsVisible()) {
            throw new AssertionError("ERROR: No se cargó correctamente la pantalla de detalles del producto.");
        }

        if (unidades > 1) {
            productDetailsScreen.increaseQuantity(unidades);
        }

        productDetailsScreen.addToCart();
    }


    public void validoElCarritoDeCompraActualiceCorrectamente(String expectedProduct, int expectedQuantity) {
        productDetailsScreen.goToCart();

        // Obtener nombre del producto y cantidad en el carrito
        String actualProduct = cartScreen.getProductNameInCart();
        int actualQuantity = cartScreen.getProductQuantityInCart();

        // Validar que el producto agregado es el correcto
        Assert.assertEquals("El producto en el carrito no coincide con el esperado", expectedProduct, actualProduct);

        // Validar que la cantidad agregada es la correcta
        Assert.assertEquals("La cantidad del producto en el carrito no es la esperada", expectedQuantity, actualQuantity);
    }


}