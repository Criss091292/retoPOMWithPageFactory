package co.com.sofka.page.jobtitlesform;

import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.page.jobtitlesform.JobTitlesForm;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobTitlesForm extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(JobTitlesForm.class);
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    @FindBy(id = "btnAdd")
    @CacheLookup
    private WebElement addBtn;

    @FindBy(id = "btnDelete")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(id = "resultTable")
    @CacheLookup
    private WebElement resultTable;

    public JobTitlesForm(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public JobTitlesForm(WebDriver driver, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);
    }

    public void goToAddJobTitle(){
        clickOn(addBtn);
    }
}
