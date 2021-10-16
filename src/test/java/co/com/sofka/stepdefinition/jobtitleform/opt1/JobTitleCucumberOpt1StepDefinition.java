package co.com.sofka.stepdefinition.jobtitleform.opt1;

import co.com.sofka.model.addjobtitleform.AddJobTitleFormModel;
import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.addjobtitleform.AddJobTitleForm;
import co.com.sofka.page.jobtitlesform.JobTitlesForm;
import co.com.sofka.page.menuform.MenuForm;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import static co.com.sofka.util.GenerateRandomString.generateRandomString;

import java.util.ArrayList;
import java.util.List;

public class JobTitleCucumberOpt1StepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(JobTitleCucumberOpt1StepDefinition.class);
    private LoginFormModel loginFormModel;
    private LoginForm loginForm;
    private MenuForm menuForm;
    private JobTitlesForm jobTitlesForm;
    private AddJobTitleForm addJobTitle;
    private AddJobTitleFormModel addJobTitleFormModel;
    private List<String> jobTitles;
    //private By botonJobTitle;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String RIGHT_USERNAME = "Admin";
    private static final String RIGHT_PASSWORD = "admin123";

    //background
    
    private static final String LANDINGPAGE_URL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    @Given("autentique exitosamente en el sitio, desde la pagina principal seleccione el menu con rutau Admin-Job-JobTitle y luego pulso add")
    public void autentique_exitosamente_en_el_sitio_desde_la_pagina_principal_seleccione_el_menu_con_rutau_admin_job_job_title_y_luego_pulso_add() {
        try{
            generalSetUp();
            doSucessfullyLogin();
            menuForm = new MenuForm(driver);
            menuForm.goToJobTitles();

            jobTitlesForm = new JobTitlesForm(driver);
            jobTitles = jobTitlesForm.getJobTitleList();
            jobTitlesForm.goToAddJobTitle();

            String jobTitle = generateJobTitleToTest(jobTitles);
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    
    @When("lleno todos los campos del formulario y pulso save")
    public void lleno_todos_los_campos_del_formulario_y_pulso_save() {
        try{
            addJobTitleFormModel = new AddJobTitleFormModel();
            addJobTitleFormModel.setJobTitle(generateJobTitleToTest(jobTitles));
            addJobTitleFormModel.setJobDescription(generateRandomString(50));
            addJobTitleFormModel.setNote(generateRandomString(20));
            addJobTitle= new AddJobTitleForm(driver, addJobTitleFormModel);
            addJobTitle.fillJobTitleForm();
            addJobTitle.submitForm();
            jobTitlesForm = new JobTitlesForm(driver);
        } catch (Exception exception){
            quitDriver();
            exception.printStackTrace();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
   
    @Then("deberia visualizarse el jobtitle y el job description diligenciado en la tabla que contiene todos los jobtitle")
    public void deberia_visualizarse_el_jobtitle_y_el_job_description_diligenciado_en_la_tabla_que_contiene_todos_los_jobtitle() {
        try {
            Assertions.assertTrue(jobTitlesForm.getJobTitleList().contains(addJobTitleFormModel.getJobTitle()),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            exception.printStackTrace();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Functions...
    public void doSucessfullyLogin(){
        loginFormModel = new LoginFormModel();
        loginFormModel.setUsername(RIGHT_USERNAME);
        loginFormModel.setPassword(RIGHT_PASSWORD);
        loginForm = new LoginForm(driver, loginFormModel);
        loginForm.doLogin(driver);
    }

    public String generateJobTitleToTest(List<String> existingJobTitlesList){
        String generatedJobTitle = generateRandomString(8);
            if(existingJobTitlesList.contains(generatedJobTitle)){
                generatedJobTitle = generateJobTitleToTest(existingJobTitlesList);
            }
            return generatedJobTitle;
    }


}
