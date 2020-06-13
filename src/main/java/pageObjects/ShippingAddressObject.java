package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.ShippingAddressUI;

public class ShippingAddressObject extends AbstractPage {
    WebDriver driver;

    public ShippingAddressObject(WebDriver _driver){
        driver = _driver;
    }

    public void clickUserMenu(){
        clickElement(driver, ShippingAddressUI.USER_MENU);
    }

    public void clickAccountInfoFromMenu(){
        clickElement(driver, String.format(ShippingAddressUI.ITEM_ON_MENU, "Thông tin tài khoản"));
    }

    public void clickShippingAddressLink(){
        clickElement(driver, ShippingAddressUI.LNK_SHIPPING_ADDRESS);
    }

    public void clickEditButton(){
        clickElements(driver, ShippingAddressUI.EDIT_BUTTON);
    }

    public void clearFirstNameTextbox(){
        clearText(driver, ShippingAddressUI.FIRST_NAME_TEXTBOX);
    }

    public void enterFirstNameIntoTextbox(String firstName){
        setText(driver, ShippingAddressUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void clearLastNameTextbox(){
        clearText(driver, ShippingAddressUI.LAST_NAME_TEXTBOX);
    }

    public void enterLastNameIntoTextbox(String lastName){
        setText(driver, ShippingAddressUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void clearAddressTextbox(){
        clearText(driver, ShippingAddressUI.ADDRESS_TEXTBOX);
    }

    public void enterAddressIntoTextbox(String address){
        setText(driver, ShippingAddressUI.ADDRESS_TEXTBOX, address);
    }

    public void selectCity(String city){
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_CITY);
        selectOptionFromDropdown(element, city);
    }

    public void selectDistrict(String district){
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_DISTRICT);
        selectOptionFromDropdown(element, district);
    }

    public void selectWard(String ward){
        WebElement element = findElementByXpath(driver, ShippingAddressUI.DRP_WARD);
        selectOptionFromDropdown(element, ward);
    }

    public void clearPhoneNumberTextbox(){
        clearText(driver, ShippingAddressUI.PHONE_NUMBER_TEXTBOX);
    }

    public void enterPhoneNumberIntoTextbox(String phoneNumber){
        setText(driver, ShippingAddressUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void clickAddressSubmitButton(){
        clickElement(driver, ShippingAddressUI.ADDRESS_SUBMIT_BUTTON);
    }

    public String getFirstNameErrorMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.FIRST_NAME_ERROR_MESSAGE);
        return actualResult;
    }

    public String getLastNameErrorMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.LAST_NAME_ERROR_MESSAGE);
        return actualResult;
    }

    public String getSuccessMessage(){
        String actualResult = getTextElement(driver, ShippingAddressUI.SUCCESS_MESSAGE);
        return actualResult;
    }

}
