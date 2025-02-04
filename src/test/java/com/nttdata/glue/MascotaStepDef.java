package com.nttdata.glue;

import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MascotaStepDef {

    MascotaStep mascota = new MascotaStep();

    @When("consulto la tienda de mascota con IDMASCOTA {int}")
    public void consultoLaTiendaDeMascotaConIDMASCOTA(int idMascota) {
        mascota.consulta(idMascota);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        mascota.validarStatusCode(statusCode);
    }

    @And("valido la respuesta sea {string}")
    public void validoLaRespuestaSea(String msg) {
        mascota.validarRespueta(msg);
    }
}
