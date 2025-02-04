package com.nttdata.glue;

import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.When;

public class MascotaStepDef {

    MascotaStep mascota = new MascotaStep();

    @When("consulto la tienda de mascota con IDMASCOTA {int}")
    public void consultoLaTiendaDeMascotaConIDMASCOTA(int idMascota) {
        mascota.consulta(idMascota);
    }
}
