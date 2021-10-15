package co.com.sofka.page.loginform;

import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);
    private LoginFormModel loginFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    //For input test cases.
    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement textUsername;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement textPassword;

    @FindBy(id = "btnLogin")
    //@CacheLookup
    private WebElement login;

    public LoginForm(WebDriver driver, LoginFormModel loginFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.loginFormModel = loginFormModel;
    }

    public LoginForm(WebDriver driver, LoginFormModel loginFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if(loginFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.loginFormModel = loginFormModel;

    }

    //Page functions.

    public void doLogin(WebDriver driver){
        try{
            typeInto(textUsername, loginFormModel.getUsername());
            typeInto(textPassword, loginFormModel.getPassword());
            doSubmit(login);
        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }

    }


}
