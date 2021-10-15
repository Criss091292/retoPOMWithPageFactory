package co.com.sofka.page.menuform;

import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MenuForm extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(MenuForm.class);
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

    @FindBy(id = "menu_admin_UserManagement")
    @CacheLookup
    private WebElement menu_admin_userManagement;

    public MenuForm(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public MenuForm(WebDriver driver, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);
    }

    public void goToJobTitles(){
        try{
            hover(menu_admin_viewAdminModule);
            System.out.println("menu admin module");
            hover(menu_admin_job);
            System.out.println("menu admin job");
            hover(menu_admin_viewJobTitleList);
            System.out.println("menu job list");
            clickOn(menu_admin_viewJobTitleList);
        } catch (Exception exception){
            exception.printStackTrace();
            LOGGER.warn(exception.getMessage());
        }
    }

    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }


}
