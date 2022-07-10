package com.boxed.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckoutPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        checkoutPage = new CheckoutPage();
    }


//    @Test(description = "go to Boxed homepage & verify page title", groups = "sample")
//    public void testHomePageNavigation() {
//        driver.get("https://www.boxed.com/");
//        assertEquals(driver.getTitle(), "Wholesale | No Membership | Save Money, Time, & Gas | Boxed", "invalid page title");
//    }
    @Test(priority = 1, groups = "real")
    public void ShopAllProductsTest(){
        driver.get("https://www.boxed.com/");
        homePage.clickLoginButton();
        homePage.userSignInWithCredentials("exanluu789@gmail.com","Boxed.com123!");
        homePage.navigateToShopAllProducts();
        homePage.addThreeProductsToCartAndCheckOut();
        checkoutPage.enterNewShippingInformation("Test","User","1990 MAIN STREET","","Santa Clara", "CA", "95050");

        //Toggle and verify payment methods
        checkoutPage.selectPayPalMethod();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(checkoutPage.verifyPayPalCtaButton());

        checkoutPage.switchToGooglePayMethod();
        sa.assertTrue(checkoutPage.verifyGooglePayCtaButton());

        checkoutPage.switchToCreditCardMethod();
        sa.assertTrue(checkoutPage.verifyCreditCardNumberField());
        sa.assertAll();

    }
    @Test(priority = 2, groups = "real")
    public void ShopSnacksTest(){
        driver.get("https://www.boxed.com/");
        homePage.clickLoginButton();
        homePage.userSignInWithCredentials("exanluu789@gmail.com","Boxed.com123!");
        homePage.navigateToSnacks();
        homePage.clickSortingToLowPrice();
        homePage.addOneProductToCart();
        homePage.addSecondProductToCart();
        homePage.navigateToViewCart();

        //Verify checkout button is grayed and disabled
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.verifyGrayedOutCheckOutButton());
        sa.assertFalse(homePage.verifyCheckOutDisabledButton());
        sa.assertAll();


    }
}
