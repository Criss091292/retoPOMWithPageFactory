package co.com.sofka.page.addjobtitleform;

import co.com.sofka.model.addjobtitleform.AddJobTitleFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.page.menuform.MenuForm;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AddJobTitleForm extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(MenuForm.class);
    private AddJobTitleFormModel addJobTitleFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    @FindBy(id = "jobTitle_jobTitle")
    @CacheLookup
    private WebElement textJobTitle;

    @FindBy(id = "jobTitle_jobDescription")
    @CacheLookup
    private WebElement textJobDescription;

    @FindBy(id = "jobTitle_jobSpec")
    @CacheLookup
    private WebElement fileJobSpecification;

    @FindBy(id = "jobTitle_note")
    @CacheLookup
    private WebElement textNote;

    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(id = "btnCancel")
    @CacheLookup
    private WebElement cancelButton;



    public AddJobTitleForm(WebDriver driver, AddJobTitleFormModel addJobTitleFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.addJobTitleFormModel= addJobTitleFormModel;
    }

    public AddJobTitleForm(WebDriver driver, AddJobTitleFormModel addJobTitleFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);
        this.addJobTitleFormModel = addJobTitleFormModel;
    }

    public void fillJobTitleForm(){
        typeInto(textJobTitle, addJobTitleFormModel.getJobTitle());
        typeInto(textJobDescription, addJobTitleFormModel.getJobDescription());
        File file = new File("src/main/resources/page/addjobtitleform/mockFile.txt");
        typeInto(fileJobSpecification,file.getAbsolutePath());
        typeInto(textNote,addJobTitleFormModel.getNote());
    }

    public void submitForm(){
        clickOn(saveButton);
    }
}
