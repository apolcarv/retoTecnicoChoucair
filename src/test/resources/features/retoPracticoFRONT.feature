  #lenguage: es

  #Proyecto: Reto tecnico Choucair
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

  Feature: Ejecución completa de los casos de pruebas RETO TECNICO CHOUCAIR del aplicativo StarSharp

    @StarSharp_PASO_(a)
    Scenario Outline: 001- Autenticacion y creacion de unidad de negocio desde el aplicativo StarSharp
      Given usuario se autentica en el aplicativo StarSharp "<ESCENARIO>" "<FUNCIONALIDAD>"
      When realiza creacion de una unidad de negocio
      Then guarda y valida que se haya creado con exito
      Examples:
        | ESCENARIO                  | FUNCIONALIDAD                              |
        | 001- RETO_TECNICO_CHOUCAIR | AUTENTICACION_Y_CREACION_UNIDAD_DE_NEGOCIO |


