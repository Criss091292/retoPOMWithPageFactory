package co.com.sofka.stepdefinition.jobtitleform.opt1;

import co.com.sofka.model.landingpage.LandingPageModel;
import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.landingpage.LandingPage;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class JobTitleCucumberOpt1StepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(JobTitleCucumberOpt1StepDefinition.class);
    private LoginFormModel loginFormModel;
    private LoginForm loginForm;
    private LandingPageModel landingPageModel;
    private LandingPage landingPage;
    //private By botonJobTitle;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";
    //background
    @Given("Me autentique exitosamente por la pagina de inicio de sesion, fui redirigido a la landing page y segui la ruta del menu admin,job job title y en el sitio pulso el boton agregar")
    public void me_autentique_exitosamente_por_la_pagina_de_inicio_de_sesion_fui_redirigido_a_la_landing_page_y_segui_la_ruta_del_menu_admin_job_job_title_y_en_el_sitio_pulso_el_boton_agregar() {
        throw new io.cucumber.java.PendingException();
        /*try{
            generalSetUp();
            dataConfiguration();
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
            //botonJobTitle = By.id("menu_admin_viewJobTitleList");
            landingPageModel = new LandingPageModel();
            landingPage = new LandingPage(driver, landingPageModel);
            landingPage.goToJobTitles();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }*/
    }

    @When("diligencio todos los campos del formulario y pulso save")
    public void diligencio_todos_los_campos_del_formulario_y_pulso_save() {
        throw new io.cucumber.java.PendingException();
        /*try {

        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }*/
    }

    /*@Then("en la pagina de job titles deberia aparecer en la tabla el no nombre y la nota guardados")
    public void en_la_pagina_de_job_titles_deberia_aparecer_en_la_tabla_el_no_nombre_y_la_nota_guardados() {
        try {

            Assertions.assertTrue(1==1,
                    ASSERTION_EXCEPTION_MESSAGE
            );
            //quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }*/

    //Funciones comunes:
    private void dataConfiguration(){
        loginFormModel = new LoginFormModel();
        loginFormModel.setUsername(USERNAME);
        loginFormModel.setPassword(PASSWORD);

    }

}
