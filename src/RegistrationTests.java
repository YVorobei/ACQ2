import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dell-user on 1/28/16.
 *
 *
 * TEST for registration page
 *
 * 1. test1_allEmptyField
 * 1. test2_allEmptyFieldWithoutCheckbox
 * 2. test3_typeFirstField
 * 3. test4_typeAllField
 * 4. test5_typeAllFieldWithoutCheckbox
 * 5. test6_specialSymbol
 * 7. test7_differentEmail
 * 8. test8_differentPassword
 *
 */
public class RegistrationTests {
    private static WebDriver driver;

    static MainPage mainPage;
    static LoginPage loginPage;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        System.out.println("Browser open successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Start test");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void test1_allEmptyField() {
        mainPage.openMainPage();
        mainPage.switchToLoginPage();
        //loginPage.fillEmailFieldRegistration("admin@gmail.com");
        //loginPage.fillRepeatEmailRegistration("admin1@gmail.com");

        loginPage.fillRepeatEmailRegistration("123test");

        loginPage.pressButtonRegister();

       // loginPage.pressLoginButton();
        Assert.assertTrue("Error mass", loginPage.isErrorShown("Error1Registration"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("End test");
        driver.quit();
    }
}
