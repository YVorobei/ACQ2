package tests;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;


/**
 * Created by Vorobei on 01.02.2016.
 */
public class LoginTests extends Fixture {

    private static final Logger log = Logger.getLogger(LoginTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        log.info("Start LoginTests");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void test1_positiveLogin() {
        mainPage.openMainPage();
        mainPage.switchToLoginPage();

        loginPage.fillEmailField("b.handozhynski@gmail.com");
        loginPage.fillPasswordfield("123456");

        loginPage.pressLoginButton();
        mainPage.userLogOut();

        Assert.assertTrue(mainPage.isUserLogOut());
    }

    @Test
    public void test2_incorrectLogin() {
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("b.handozhynski@gmail.com");
        loginPage.fillPasswordfield("false123456");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMessFalseLoginPass"), "Incorrect password to the system with correct login");
    }

    @Test
    public void test3_blankEmailField() {

        loginPage.fillEmailField(" ");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMess"), "Error mass NOT shown in case blank Email Field");
    }


    @Test
    public void test4_blankPasswordField() {

        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("EmptyPassError"), "Error mass NOT shown in case blank Pass Field");

    }

    @Test
    public void test5_negativeLogin() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMessFalseLoginPass"), "Error mass NOT shown in case blank Pass Field");
    }

    @Test
    public void test6_blankEmailAndPasswordField() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMessEmptyEmailField"), "Error mass NOT shown in case blank Pass Field");
    }

    @Test
    public void test7_specialSymbol() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("!@#&^");
        loginPage.fillPasswordfield("!@#&^");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMessFalseLoginPass"), "Error mass NOT shown in case blank Pass Field");
    }

    @Test
    public void test8_maxFalsePassword() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("admin@test12345561515.com");
        loginPage.fillPasswordfield("111112222222233333333444444444455555555555666666666777777777888888loginPage.isErrorShown444444445555555555566666677888888loginPage.isErrorShow");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMessFalseLoginPass"), "Error mass NOT shown in case blank Pass Field");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        log.info("End LoginTests");
    }

}
