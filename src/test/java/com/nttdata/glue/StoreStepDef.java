package com.nttdata.glue;

import com.nttdata.steps.StoreStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;

public class StoreStepDef {

    @Steps
    StoreStep storeStep;

    @Given("que el usuario tiene acceso al servicio de Store")
    public void que_el_usuario_tiene_acceso_al_servicio_de_store() {
        storeStep.definirUrl();
    }

    @When("se envía una solicitud para crear una orden con los siguientes datos:")
    public void se_envia_una_solicitud_para_crear_una_orden(io.cucumber.datatable.DataTable dataTable) {
        storeStep.crearOrden(dataTable);
    }

    @Then("el sistema debe responder con código {int}")
    public void el_sistema_debe_responder_con_codigo(int statusCode) {
        assertEquals(statusCode, storeStep.obtenerCodigoRespuesta());
    }

    @Then("el cuerpo de la respuesta debe contener la orden creada con los datos enviados")
    public void el_cuerpo_de_la_respuesta_debe_contener_la_orden_creada() {
        storeStep.validarOrdenCreada();
    }

    @When("se consulta la orden con el ID {int}")
    public void se_consulta_la_orden_con_el_id(int orderId) {
        storeStep.consultarOrden(orderId);
    }

    @Then("el cuerpo de la respuesta debe contener los datos correctos de la orden")
    public void el_cuerpo_de_la_respuesta_debe_contener_los_datos_correctos() {
        storeStep.validarOrdenConsultada();
    }
}