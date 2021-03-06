package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vorobei on 01.02.2016.
 */
public class Fixture {
    public static WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public ProductPage productPage;

    private static final Logger log = Logger.getLogger(Fixture.class);

    @BeforeSuite
    public void setEnv(){
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();

        log.info("Browser open successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //@AfterSuite
    public void resetEnv(){
        if (driver != null){
            driver.quit();
            log.info("Browser close successful");
        }
        log.info("Tests Suite execution completed.");
    }


}
