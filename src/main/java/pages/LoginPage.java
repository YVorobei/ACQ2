package pages;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by Vorobei on 01.02.2016.
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


    public void switchToMainPage() {
        try {
            web.clickLink("LogoOnLoginPage");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        try {
            if (web.isElementPresent("LandingContainer")) {
                log.info("SwitchTo Main Page was correct");
            } else {
                log.error("SwitchTo Main Page was INCORRECT");
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }


}
