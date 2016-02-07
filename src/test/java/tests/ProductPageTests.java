package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;

/**
 * Created by Vorobei on 05.02.2016.
 *
 * TEST for product Page
 *
 * 1.  test1_positiveOpenProductPage
 * 2.  test2_positiveBuyProduct
 * 3.  test3_positiveCheckNameProduct
 * 4.  test4_positiveCheckPriceProduct
 * 5.  test5_positiveCheckTabProduct
 *
 */
public class ProductPageTests extends Fixture{

    private static final Logger log = Logger.getLogger(LoginTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        log.info("Start LoginTests");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    /*@Test
     public void test1_openProductPage() {
        mainPage.openMainPage();
        mainPage.refreshPage();

        //(or menu class)
        mainPage.switchToUnderwearBathMenu();

        productPage.switchToPantiesCategory();
        //or switchToStandartProductPage
        //or switchToProductPage
        productPage.switchToFirstProductPage();

        Assert.assertTrue(productPage.checkCorrectSwitchToProductPage(), "INCorrect switch to product page");
    } */


    //@Test
    public void test1_positiveOpenProductPage() {
        mainPage.openMainPage();
        mainPage.refreshPage();
        mainPage.switchToUnderwearBathMenu();
        productPage.switchToPantiesCategory();
        productPage.switchToFirstProductPage();
        Assert.assertTrue(productPage.checkCorrectSwitchToProductPage(), "INCorrect switch to product page");
    }


    @Test
    public void test2_positiveBuyProduct() {
        mainPage.openMainPage();
        mainPage.refreshPage();
        mainPage.switchToUnderwearBathMenu();
        productPage.switchToPantiesCategory();
        productPage.switchToFirstProductPage();

        Assert.assertTrue(productPage.checkCorrectSwitchToProductPage(), "INCorrect switch to product page");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        log.info("End LoginTests");
    }
}
