package pages;

import com.boxed.web.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    //Locators
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='emailForLogin']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='passwordForLogin']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
    WebElement signInButton;

    @FindBy(xpath = "(//a[@href='/products/category/342/all-boxed'])[1]")
    WebElement categoriesTab;

    @FindBy(xpath = "//a[contains(text(),'Shop All Products')]")
    WebElement shopAllProductsTab;

    @FindBy(xpath = "(//button[@aria-label='Add to cart'])[1]")
    WebElement firstProductAddToCart;

    @FindBy(xpath = "(//button[@aria-label='Add to cart'])[2]")
    WebElement secondProductAddToCart;

    @FindBy(xpath = "(//button[@aria-label='Add to cart'])[3]")
    WebElement thirdProductAddToCart;

    @FindBy(xpath = "//button[contains(text(),'CHECK OUT')]")
    WebElement checkoutButton;

    @FindBy(xpath = "//a[contains(text(),'Snacks')]")
    WebElement snacksTab;

    @FindBy(xpath = "//span[contains(text(),'SORT')]")
    WebElement sortButton;

    @FindBy(xpath = "//li[contains(text(),'Price (Low to High)')]")
    WebElement selectLowToHigh;

    @FindBy(xpath = "//button[contains(text(),'CONTINUE SHOPPING')]")
    WebElement continueShoppingLink;

    @FindBy(xpath = "//button[contains(text(),'VIEW CART')]")
    WebElement viewCartButton;

    @FindBy(xpath = "//button[contains(text(),'TO CHECK OUT')]")
    WebElement grayedOutCheckOutButton;


    //initialize page objects
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    //Methods
    public void clickLoginButton(){
        loginButton.click();
    }
    public void userSignInWithCredentials(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
    public void navigateToShopAllProducts(){
        Actions action = new Actions(driver);
        action.moveToElement(categoriesTab).perform();
        action.moveToElement(shopAllProductsTab).click().perform();
    }
    public void addThreeProductsToCartAndCheckOut(){
        firstProductAddToCart.click();
        secondProductAddToCart.click();
        checkoutButton.click();
    }
    public void navigateToSnacks(){
        Actions action = new Actions(driver);
        action.moveToElement(categoriesTab).perform();
        action.moveToElement(snacksTab).click().perform();
    }
    public void clickSortingToLowPrice(){
        sortButton.click();
        selectLowToHigh.click();
    }
    public void addOneProductToCart(){
        firstProductAddToCart.click();
    }
    public void addSecondProductToCart(){
        secondProductAddToCart.click();
    }
    public void navigateToViewCart(){
        viewCartButton.click();
    }
    public boolean verifyGrayedOutCheckOutButton(){
        return grayedOutCheckOutButton.isDisplayed();
    }
    public boolean verifyCheckOutDisabledButton(){
        return grayedOutCheckOutButton.isEnabled();
    }
    public void JsClickLoginBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);
    }

}
