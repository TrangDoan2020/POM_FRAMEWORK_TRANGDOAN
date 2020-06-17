package pageObjects;

import commons.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.ShippingAddressUI;

public class ShippingAddressObject extends AbstractPage {
    WebDriver driver;

    Logger logger = Logger.getLogger(ShippingAddressObject.class.getSimpleName());

    public ShippingAddressObject(WebDriver _driver){
        driver = _driver;
    }

    public void clickUserMenu(){
        logger.info("Click User menu");
        clickElement(driver, ShippingAddressUI.USER_MENU);
    }

    public void clickAccountInfoFromMenu(){
        logger.info("Click Account info from menu");
        clickElement(driver, String.format(ShippingAddressUI.ITEM_ON_MENU, "Thông tin tài khoản"));
    }

    public void clickShippingAddressLink(){
        logger.info("Click Shipping Address link");
        clickElement(driver, ShippingAddressUI.LNK_SHIPPING_ADDRESS);
    }

    public void clickEditButton(){
        logger.info("Click Edit button");
        clickElements(driver, ShippingAddressUI.EDIT_BUTTON);
    }

    public void clearFirstNameTextbox(){
        logger.info("Clear FirstName textbox");
        clearText(driver, ShippingAddressUI.FIRST_NAME_TEXTBOX);
    }

    public void enterFirstNameIntoTextbox(String firstName){
        logger.info("Enter FirstName " + firstName +  " into textbox");
        setText(driver, ShippingAddressUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void clearLastNameTextbox(){
        logger.info("Clear LastName textbox");
        clearText(driver, ShippingAddressUI.LAST_NAME_TEXTBOX);
    }

    public void enterLastNameIntoTextbox(String lastName){
        logger.info("Enter LastName " + lastName +  " into textbox");
        setText(driver, ShippingAddressUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void clearAddressTextbox(){
        logger.info("Clear Address textbox");
        clearText(driver, ShippingAddressUI.ADDRESS_TEXTBOX);
    }

    public void enterAddressIntoTextbox(String address){
        logger.info("Enter Address " + address +  " into textbox");
        setText(driver, ShippingAddressUI.ADDRESS_TEXTBOX, address);
    }

    public void selectCity(String city){
        logger.info("Select City");
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_CITY);
        selectOptionFromDropdown(element, city);
    }

    public void selectDistrict(String district){
        logger.info("Select District");
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_DISTRICT);
        selectOptionFromDropdown(element, district);
    }

    public void selectWard(String ward){
        logger.info("Select Ward");
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_WARD);
        selectOptionFromDropdown(element, ward);
    }

    public void clearPhoneNumberTextbox(){
        logger.info("Clear PhoneNumber textbox");
        clearText(driver, ShippingAddressUI.PHONE_NUMBER_TEXTBOX);
    }

    public void enterPhoneNumberIntoTextbox(String phoneNumber){
        logger.info("Enter PhoneNumber " + phoneNumber +  " into textbox");
        setText(driver, ShippingAddressUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void clickAddressSubmitButton(){
        logger.info("Click Address submit button");
        clickElement(driver, ShippingAddressUI.ADDRESS_SUBMIT_BUTTON);
    }

    public String getFirstNameErrorMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.FIRST_NAME_ERROR_MESSAGE);
        logger.info("Get FirstName error message" + actualResult);
        return actualResult;
    }

    public String getLastNameErrorMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.LAST_NAME_ERROR_MESSAGE);
        logger.info("Get LastName error message" + actualResult);
        return actualResult;
    }

    public String getSuccessMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.SUCCESS_MESSAGE);
        logger.info("Get success message" + actualResult);
        return actualResult;
    }

}
