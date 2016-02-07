package pages;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

import java.util.Date;
import java.util.Random;

/**
 * Created by Dell-user on 2/3/16.
 */
public class RegistrationPage {

    WebDriver driver;
    WebElementsActions web;
    //String emailValue = generateEmail();

    private static final Logger log = Logger.getLogger(ProductPage.class);

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }


    public String generateEmail(){
        final Date date = new Date();
        String prepareTestMail = date.getTime() + "el" + "@testdomain.com";
        String newTestMail = prepareTestMail.substring(5);
        return newTestMail;
    }

   /* public String copyGenerateEmail(String valueGenerateMail){
        return valueGenerateMail;
    }*/

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

    public void fillPasswordRegistration(String value){
        try {
            web.input("TextPasswordTextRegistration", value);
            log.info("input to PassField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillRepeatPasswordRegistration(String value){
        try {
            web.input("TextPasswordRepeatText", value);
            log.info("input to RepeatPassField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void inActiteCheckboxRegistration(){
        try {
            web.selectCheckbox("InputCheckbox", "N");
            //  web.selectCheckbox("InputCheckbox", "N");
        } catch (NoElementFound noElementFound){
            noElementFound.printStackTrace();
        }
    }

    public void pressCheckBox(){
        try {
            web.selectCheckboxReg("InputCheckbox");
        }  catch (NoElementFound noElementFound){
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
