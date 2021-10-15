package co.com.sofka.page.landingpage;

import co.com.sofka.model.landingpage.LandingPageModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(LandingPage.class);
    private LandingPageModel landingPageModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    @FindBy(id = "welcome")
    @CacheLookup
    private WebElement welcomeMessage;

    @FindBy(id = "menu_admin_viewAdminModule")
    @CacheLookup
    private WebElement menu_admin_viewAdminModule;

    @FindBy(id = "menu_admin_Job")
    @CacheLookup
    private WebElement menu_admin_job;

    @FindBy(id = "menu_admin_viewJobTitleList")
    @CacheLookup
    private WebElement menu_admin_viewJobTitleList;

    public LandingPage(WebDriver driver, LandingPageModel landingPageModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.landingPageModel = landingPageModel;
    }

    public LandingPage(WebDriver driver, LandingPageModel landingPageModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if(landingPageModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.landingPageModel = landingPageModel;

    }

    public void goToJobTitles(){
        try{
            /*
            hover(menu_admin_viewAdminModule);
            hover(menu_admin_job);
            hover(menu_admin_viewJobTitleList);
             */
            clickOn(menu_admin_viewJobTitleList);
        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }
}
