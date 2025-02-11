package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class CartStepDefinitions {

    @Steps
    CartSteps cartSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        cartSteps.estoyEnLaAplicacionDeSauceLabs();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        cartSteps.validoQueCarguenCorrectamenteLosProductosEnLaGaleria();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        cartSteps.agregoDelSiguienteProducto(unidades, producto);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        cartSteps.validoElCarritoDeCompraActualiceCorrectamente();
    }
}