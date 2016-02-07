package tests;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dell-user on 1/28/16.
 *
 *
 * TEST for registration Page
 *
 * 1.  test1_positiveRegistration
 * 2.  test2_positiveTestPass4length
 * 3.  test3_positiveTestWithoutCheckbox
 * 4.  test4_positiveSpecialSymbol
 * 5.  test5_negativeShortPassword
 * 6.  test6_negativeDifferentPassword
 * 7.  test7_negativeDifferentEmail
 * 8.  test8_negativeAllEmptyField
 * 9.  test9_negativeAllEmptyFieldWithoutCheckbox
 * 10. test10_negativeExistsData
 *
 */
public class RegistrationTests extends Fixture {
    private static final Logger log = Logger.getLogger(LoginTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        log.info("Start LoginTests");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }


    @Test
    public void test1_positiveRegistration(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("123456ASD");
        registrationPage.fillRepeatPasswordRegistration("123456ASD");
        registrationPage.pressButtonRegister();
        mainPage.userLogOut();
        Assert.assertTrue(mainPage.isUserLogOut());
    }

    @Test
    public void test2_positiveTestPass4length(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("1234");
        registrationPage.fillRepeatPasswordRegistration("1234");
        registrationPage.pressButtonRegister();
        mainPage.userLogOut();
        Assert.assertTrue(mainPage.isUserLogOut());
    }

    @Test
    public void test3_positiveTestWithoutCheckbox(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("A1234");
        registrationPage.fillRepeatPasswordRegistration("A1234");
        registrationPage.pressCheckBox();
        registrationPage.pressButtonRegister();
        mainPage.userLogOut();
        Assert.assertTrue(mainPage.isUserLogOut());
    }

    @Test
    public void test4_positiveSpecialSymbol(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("!@1238*_12ASда..");
        registrationPage.fillRepeatPasswordRegistration("!@1238*_12ASда..");
        registrationPage.pressButtonRegister();
        mainPage.userLogOut();
        Assert.assertTrue(mainPage.isUserLogOut());
    }

    @Test
    public void test5_negativeShortPassword(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("123");
        registrationPage.fillRepeatPasswordRegistration("123");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("ErrorRegistrationShortPassword"), "Incorrect password to the system with correct e-mail");
    }

    @Test
    public void test6_negativeDifferentPassword(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        String emailValue = registrationPage.generateEmail();
        registrationPage.fillEmailFieldRegistration(emailValue);
        registrationPage.fillRepeatEmailRegistration(emailValue);
        registrationPage.fillPasswordRegistration("12345");
        registrationPage.fillRepeatPasswordRegistration("1234");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("ErrorRegistrationShortPassword"), "Incorrect password to the system with correct e-mail");
    }

    @Test
    public void test7_negativeDifferentEmail(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        registrationPage.fillEmailFieldRegistration(registrationPage.generateEmail());
        registrationPage.fillRepeatEmailRegistration(registrationPage.generateEmail());
        registrationPage.fillPasswordRegistration("12345");
        registrationPage.fillRepeatPasswordRegistration("12345");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("ErrorRegistrationShortPassword"), "Correct password to the system with Incorrect e-mail");

    }

    @Test
    public void test8_negativeAllEmptyField(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        registrationPage.fillEmailFieldRegistration("");
        registrationPage.fillRepeatEmailRegistration("");
        registrationPage.fillPasswordRegistration("");
        registrationPage.fillRepeatPasswordRegistration("");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("EmptyAllFieldError"), "Empty all fields");
    }

    @Test
    public void test9_negativeAllEmptyFieldWithoutCheckbox(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        registrationPage.fillEmailFieldRegistration("");
        registrationPage.fillRepeatEmailRegistration("");
        registrationPage.fillPasswordRegistration("");
        registrationPage.fillRepeatPasswordRegistration("");
        registrationPage.pressCheckBox();
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("EmptyAllFieldError"), "Empty all fields without active checkbox (get news)");
    }

    @Test
    public void test10_negativeExistsData(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        registrationPage.fillEmailFieldRegistration("admin@gmail.com");
        registrationPage.fillRepeatEmailRegistration("admin@gmail.com");
        registrationPage.fillPasswordRegistration("!@1238*_12ASда..");
        registrationPage.fillRepeatPasswordRegistration("!@1238*_12ASда..");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("ErrorRegistrationShortPassword"), "E-mail address is already registered");
    }
}
