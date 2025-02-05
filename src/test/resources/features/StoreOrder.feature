@ProbarFeatureOrdenPetStore
Feature: Validación de la API Store en PetStore

  Como automatizador principal en NTT
  Quiero garantizar la integridad del API Store
  Para asegurar que los pedidos se creen y consulten correctamente

  @CrearOrdenPet
  Scenario Outline: Creación de una orden en la tienda de mascotas
    Given que el usuario tiene acceso al servicio de Store
    When se envía una solicitud para crear una orden con los siguientes datos:
      | id   | petId   | quantity   | shipDate   | status   | complete   |
      | <id> | <petId> | <quantity> | <shipDate> | <status> | <complete> |
    Then el sistema debe responder con código 200
    And el cuerpo de la respuesta debe contener la orden creada con los datos enviados

    Examples:
      | id   | petId | quantity | shipDate                 | status | complete |
      | 1313 | 13    | 13       | 2025-02-05T00:53:41.410Z | placed | true     |

  @consultarOrdenPet
  Scenario Outline: Consulta de una orden en la tienda de mascotas
    Given que el usuario tiene acceso al servicio de Store
    When se consulta la orden con el ID <id>
    Then el sistema debe responder con código 200
    And el cuerpo de la respuesta debe contener los datos correctos de la orden

    Examples:
      | id   |
      | 1313 |