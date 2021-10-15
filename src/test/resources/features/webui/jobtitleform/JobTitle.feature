# new feature
# Tags: optional

Feature: Yo como encargado de seleccion
  quiero crear nombres de empleo
  para generar las vacantes

  Background:
    Given Me autentique exitosamente por la pagina de inicio de sesion, fui redirigido a la landing page y segui la ruta del menu admin,job job title y en el sitio pulso el boton agregar
  Scenario: Añadir titulo utilizando todos los campos del formulario
    When diligencio todos los campos del formulario y pulso save
    Then en la pagina de job titles deberia aparecer en la tabla el no nombre y la nota guardados