package com.nttdata.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class MascotaStep {

    public void consulta(int idMascota){
        System.out.println("Hola, ejecutado desde el metodo Consultar Macota");

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .get("https://petstore.swagger.io/v2/pet/13")
                .then()
                .statusCode(200)
                ;
    }


}
