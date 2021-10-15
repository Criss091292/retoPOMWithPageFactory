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
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
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

    @FindBys({
            @FindBy(id = "resultTable"),
            @FindBy(tagName = "tbody"),
            @FindBy(tagName = "tr")
    })
    @CacheLookup
    private List<WebElement> resultTableWithouthHeadings;

    @FindBys({
            @FindBy(id = "resultTable"),
            @FindBy(tagName = "tr"),
            @FindBy(tagName = "td")
    })
    @CacheLookup
    private List<WebElement> resultTableCells;

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

    public List<WebElement> getResultTableWithOuthHeadings(){
        return resultTableWithouthHeadings;
    }

    public List<String> getJobTitleList(){
        List<String> jobTitlesList = new ArrayList<String>();
        int i=0;
        for (WebElement cell: resultTableCells){
            if( i % 3 ==1){
                jobTitlesList.add(cell.getText());
            }
            i++;
        }
        return jobTitlesList;
    }
}
