import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by ViTaLES on 16.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {

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
        Assert.assertTrue("Incorrect login to the system with fake log/pass", loginPage.isErrorShown("ErrorMessFalseLoginPass"));
    }

    @Test
    public void test3_blankEmailField() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();
        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMessEmptyEmailField"));
    }

    @Test
    public void test4_blankPasswordField() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();
        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMessEmptyEmailField"));
    }

    @Test
    public void test5_negativeLogin() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();
        Assert.assertTrue("Incorrect login to the system with fake log/pass", loginPage.isErrorShown("ErrorMessFalseLoginPass"));
    }

    @Test
    public void test6_blankEmailAndPasswordField() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();
        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMessEmptyEmailField"));
    }

    @Test
      public void test7_specialSymbol() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("!@#&^");
        loginPage.fillPasswordfield("!@#&^");
        loginPage.pressLoginButton();
        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMessFalseLoginPass"));
    }

    @Test
    public void test8_maxFalsePassword() {
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("admin@test.com");
        loginPage.fillPasswordfield("111112222222233333333444444444455555555555666666666777777777888888loginPage.isErrorShown444444445555555555566666677888888loginPage.isErrorShow");
        loginPage.pressLoginButton();
        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMessFalseLoginPass"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
       System.out.println("End test");
       driver.quit();
    }
}
