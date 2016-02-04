import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());
    private static final Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }


    public void fillEmailField(String value) {
        try {
            web.clearAndInput("EmailField", value);
            log.info("input to EmailField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillPasswordfield(String value) {
        try {
            web.input("PassField", value);
            log.info("input to PassField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void pressLoginButton() {
        try {
            web.clickButton("LoginButton");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public boolean isErrorShown(String locator) {
        try {
            if (web.isElementPresent(locator)) {
                log.info("Error is present - " + web.getElement(locator).getText());
                return true;
            } else {
                log.error("Error is NOT present - " + web.getElement(locator).getText());
                return false;
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        return false;
    }

    //REGISTRATION PAGE

    public void fillEmailFieldRegistration(String value) {
        try {
            web.clearAndInput("TextEmailRegistration", value);
            log.info("input to TextEmailRegistration - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillRepeatEmailRegistration(String value) {
        try {
            web.clearAndInput("TextRepeatEmailRegistration", value);
            log.info("input to TextRepeatEmailRegistration - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillPasswordRegistration1(String value){
        try {
            web.clearAndInput("TextPasswordTextRegistration", value);
            log.info("input to TextPasswordTextRegistration - " + value);
        } catch (NoElementFound noElementFound){
            noElementFound.printStackTrace();
        }
    }

    public void fillRepeatPasswordRegistration(String value){
        try {
            web.clearAndInput("TextPasswordRepeatText", value);
            log.info("input to TextPasswordRepeatText - " + value);
        } catch (NoElementFound noElementFound){
            noElementFound.printStackTrace();
        }
    }

    public void pressButtonRegister() {
        try {
            web.clickButton("ButtonRegister");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}