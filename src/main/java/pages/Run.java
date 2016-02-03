package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dell-user on 2/3/16.
 */
public class Run {

    static public String generateEmail(){
        final Random random = new Random();
        String newTestMail = random.nextInt(250000) + "el" + "@testdomain.com";
        return newTestMail;
    }

    static public String generateEmail1(){
        final Date date = new Date();
        String newTestMail = date.getTime() + "el" + "@testdomain.com";
        String shortTestMail = newTestMail.substring(5);
        return shortTestMail;
    }

    static public String copyEmail(){
        return generateEmail();
    }


    public static void main(String[] args) {


       /* WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2f");
        driver.findElement(By.xpath("//input[@id='textEmail']")).sendKeys("123");

        System.out.print(driver.findElement(By.xpath("//input[@id='textEmail']")).getText());*/

        //System.out.print(copyEmail(generateEmail()));
        //System.out.print(generateEmail1());
    }
}
