package com.nttdata.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class MascotaStep {

    private String URL_BASE = "https://petstore.swagger.io/v2/";

    public void consulta(int idMascota){
        System.out.println("Hola, ejecutado desde el metodo Consultar Macota");

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                //.get("https://petstore.swagger.io/v2/pet/3256")
                .get("pet/" + String.valueOf(idMascota))
                .then()
                .log().all()
                //.statusCode(404)
                ;
    }


    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().statusCode());
    }

    public void validarRespueta(String msg) {
        String respuesta = SerenityRest.lastResponse().getBody().path("message");
        Assert.assertEquals(msg, respuesta);
    }
}
