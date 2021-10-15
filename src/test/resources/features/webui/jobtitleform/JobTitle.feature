# new feature
# Tags: optional

Feature: Yo como encargado de seleccion quiero crear nombres de empleo para generar las vacantes

  //Background:

  Scenario: Añadir titulo utilizando todos los campos del formulario
    Given autentique exitosamente en el sitio, desde la pagina principal seleccione el menu con rutau Admin-Job-JobTitle y luego pulso add
    When lleno todos los campos del formulario y pulso save
    Then deberia visualizarse el jobtitle y el job description diligenciado en la tabla que contiene todos los jobtitle
