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
 * 1.  test1_positiveTest
 * 2.  test2_positiveTestPass4length
 * 3.  test3_positiveTestWithoutCheckbox
 * 4.  test4_negativeShortPassword
 * 5.  test5_negativeDifferentPassword
 * 6.  test6_negativeDifferentEmail
 * 7.  test7_negativeAllEmptyField
 * 8.  test8_negativeAllEmptyFieldWithoutCheckbox
 * 9.  test9_negativeSpecialSymbol
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

   // @Test
    public void test2_positiveTestPass4length(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();

        registrationPage.fillEmailFieldRegistration(registrationPage.generateEmail());
       // registrationPage.fillRepeatEmailRegistration(registrationPage.copyGenerateEmail(registrationPage.generateEmail()));
        registrationPage.fillPasswordRegistration("1234");
        registrationPage.fillRepeatPasswordRegistration("1234");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(mainPage.isUserLogOut());
    }

   // @Test
    public void test3_positiveTestWithoutCheckbox(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();

        registrationPage.fillEmailFieldRegistration(registrationPage.generateEmail());
       // registrationPage.fillRepeatEmailRegistration(registrationPage.copyGenerateEmail(registrationPage.generateEmail()));
        registrationPage.fillPasswordRegistration("1234");
        registrationPage.fillRepeatPasswordRegistration("1234");
        registrationPage.pressCheckBox();
        registrationPage.pressButtonRegister();
        Assert.assertTrue(mainPage.isUserLogOut());
    }
    //@Test
    public void test4_negativeShortPassword(){
        mainPage.openMainPage();
        mainPage.switchToLoginPage();

        registrationPage.fillEmailFieldRegistration(registrationPage.generateEmail());
      //  registrationPage.fillRepeatEmailRegistration(registrationPage.copyGenerateEmail(registrationPage.generateEmail()));
        registrationPage.fillPasswordRegistration("123");
        registrationPage.fillRepeatPasswordRegistration("123");
        registrationPage.pressButtonRegister();
        Assert.assertTrue(loginPage.isErrorShown("ErrorMessFalseLoginPass"), "Incorrect password to the system with correct login");
    }

}
