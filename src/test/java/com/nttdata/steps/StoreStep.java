package com.nttdata.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StoreStep {

    private static final String URL = "https://petstore.swagger.io/v2"; // URL fija en la clase
    private Response response;
    private JSONObject requestBody;

    @Step("Definir la URL base")
    public void definirUrl() {
        System.out.println("La URL base del servicio es: " + URL);
    }

    @Step("Crear una orden en la tienda de mascotas")
    public void crearOrden(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        requestBody = new JSONObject();
        requestBody.put("id", Integer.parseInt(data.get("id")));
        requestBody.put("petId", Integer.parseInt(data.get("petId")));
        requestBody.put("quantity", Integer.parseInt(data.get("quantity")));
        requestBody.put("shipDate", data.get("shipDate"));
        requestBody.put("status", data.get("status"));
        requestBody.put("complete", Boolean.parseBoolean(data.get("complete")));

        response = given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(URL + "/store/order");

        response.then().log().all();
    }

    @Step("Obtener código de respuesta")
    public int obtenerCodigoRespuesta() {
        return response.getStatusCode();
    }

    @Step("Validar que la orden fue creada correctamente")
    public void validarOrdenCreada() {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        assertNotNull(jsonResponse);
        assertEquals(requestBody.getInt("id"), jsonResponse.optInt("id", -1));
        assertEquals(requestBody.getInt("petId"), jsonResponse.optInt("petId", -1));
        assertEquals(requestBody.getString("status"), jsonResponse.optString("status", ""));
    }

    @Step("Consultar una orden en la tienda")
    public void consultarOrden(int orderId) {
        response = given()
                .contentType("application/json")
                .get(URL + "/store/order/" + orderId);

        response.then().log().all();
    }

    @Step("Validar que la orden consultada es la correcta")
    public void validarOrdenConsultada() {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        assertNotNull(jsonResponse);

        // Verificar que la respuesta contiene un ID válido
        assertNotNull(jsonResponse.get("id"));

        // Puedes imprimir la respuesta para verificar qué datos devuelve
        System.out.println("Respuesta de la API: " + jsonResponse.toString());
    }
}
