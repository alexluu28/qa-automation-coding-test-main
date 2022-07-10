package pages;

import com.boxed.web.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BaseTest {

    //Locators
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@name='addressLine1']")
    WebElement addressLineOneField;

    @FindBy(xpath = "//input[@name='addressLine2']")
    WebElement addressLineTwoField;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//span[contains(text(),'& CONTINUE')]")
    WebElement saveAndContinueButton;

    @FindBy(xpath = "(//button[contains(text(),'SELECT')])[1]")
    WebElement selectSuggestedAddress1;

    @FindBy(xpath = "//button[@aria-label='Pay with PayPal']")
    WebElement selectPaypalButton;

    @FindBy(xpath = "(//*[contains(@id, 'zoid-paypal-buttons-uid_')])[1]")
    WebElement paypalCtaButton;

    @FindBy(xpath = "(//span[contains(text(),'Edit')])[2]")
    WebElement editPaymentButton;

    @FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
    WebElement editShippingButton;

    @FindBy(xpath = "//button[@aria-label='Select Google Pay as the payment method']")
    WebElement selectGooglePayButton;

    @FindBy(xpath = "(//button[@title='Buy with Google Pay'])[2]")
    WebElement googlePayCtaButton;

    @FindBy(xpath = "//button[contains(text(),'ADD PAYMENT METHOD')]")
    WebElement addPaymentMethodButton;

    @FindBy(xpath = "//button[@aria-label='Pay with Credit Card']")
    WebElement creditCardButton;

    @FindBy(xpath = "//input[@id='ccNumber']")
    WebElement creditCardNumberField;

    @FindBy(xpath = "//button[contains(text(),'ADD NEW ADDRESS')]")
    WebElement addNewAddressButton;


    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void enterNewShippingInformation(String firstName, String lastName, String addressOne, String addressTwo, String city, String stateCode, String zipcode){
        editShippingButton.click();
        addNewAddressButton.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressLineOneField.sendKeys(addressOne);
        lastNameField.click();
        addressLineTwoField.sendKeys(addressTwo);
        cityField.sendKeys(city);
        Select dropdownState = new Select(driver.findElement(By.tagName("select")));
        dropdownState.selectByValue(stateCode);
        zipCodeField.sendKeys(zipcode);
        saveAndContinueButton.click();
        selectSuggestedAddress1.click();

    }
    public void selectPayPalMethod(){
        selectPaypalButton.click();
    }
    public void switchToGooglePayMethod(){
        editPaymentButton.click();
        selectGooglePayButton.click();

    }
    public void switchToCreditCardMethod(){
        editPaymentButton.click();
        addPaymentMethodButton.click();
        creditCardButton.click();

    }
    public boolean verifyPayPalCtaButton(){
        return paypalCtaButton.isDisplayed();
    }
    public boolean verifyGooglePayCtaButton(){
        return googlePayCtaButton.isDisplayed();
    }
    public boolean verifyCreditCardNumberField(){
        return creditCardNumberField.isDisplayed();
    }


}
