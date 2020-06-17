package pageObjects;

import commons.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.ProfilePageUI;

public class ProfilePageObject extends AbstractPage {
    WebDriver driver;

    Logger logger = Logger.getLogger(ProfilePageObject.class.getSimpleName());

    public ProfilePageObject(WebDriver _driver){
        driver = _driver;
    }

    public void clickUserMenu(){
        logger.info("Click User menu");
        clickElement(driver, ProfilePageUI.USER_MENU);
    }

    public void clickAccountInfoFromMenu(){
        logger.info("Click Account info from menu");
        clickElement(driver, String.format(ProfilePageUI.ITEM_ON_MENU, "Thông tin tài khoản"));
    }

    public void clickAvatar(){
        logger.info("Click Avatar");
        clickElement(driver, ProfilePageUI.CHANGE_AVATAR_BUTTON);
    }

    public void clickChoosePhotoButtonOnPopup(){
        logger.info("Click choose photo button on popup");
        clickElement(driver, ProfilePageUI.CHOOSE_PHOTO_FROM_COMPUTER_BUTTON);
    }

    public void selectAPhotoFromComputer(String filePath){
        logger.info("Select a photo from computer");
        uploadFileWithRobot(filePath);
    }

    public void clickUploadSubmitButtonOnPopup(){
        logger.info("Click upload submit button on popup");
        clickElement(driver, ProfilePageUI.UPLOAD_SUBMIT_BUTTON);
    }

    public void waitUploadPopupDisappear(){
        logger.info("Wait upload popup disappear");
        waitToElementsIsNotVisible(driver, 5, ProfilePageUI.UPLOAD_SUBMIT_BUTTON);
    }

    public void clearFirstNameTextbox(){
        logger.info("Clear FirstName textbox");
        clearText(driver, ProfilePageUI.FIRST_NAME_TEXTBOX);
    }

    public void enterFirstNameIntoTextbox(String firstName){
        logger.info("Enter FirstName " + firstName + " into textbox");
        setText(driver, ProfilePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void clearLastNameTextbox(){
        logger.info("Clear LastName textbox");
        clearText(driver, ProfilePageUI.LAST_NAME_TEXTBOX);
    }

    public void enterLastNameIntoTextbox(String lastName){
        logger.info("Enter LastName " + lastName + " into textbox");
        setText(driver, ProfilePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void checkGender(String gender){
        logger.info("Check Gender");
        clickElement(driver, String.format(ProfilePageUI.GENDER_CHECKBOX, gender));

    }

    public void clickBirthdayDatePicker(){
        logger.info("Click Birthday date picker");
        clickElement(driver, ProfilePageUI.BIRTHDAY_DATE_PICKER);
    }

    public void selectDayFromDatePicker(String day){
        logger.info("Select Day from date picker");
        clickElement(driver, String.format(ProfilePageUI.DAY_DATE_PICKER, day));
    }

    public void selectMonthFromDatePicker(String month){
        logger.info("Select Month from date picker");
        WebElement element = findElementByXpath(driver, ProfilePageUI.MONTH_DATE_PICKER);
        selectOptionFromDropdown(element, month);
    }

    public void selectYearFromDatePicker(String year){
        logger.info("Select Year from date picker");
        WebElement element = findElementByXpath(driver, ProfilePageUI.YEAR_DATE_PICKER);
        selectOptionFromDropdown(element, year);
    }

    public void waitCalendarDisappear(){
        logger.info("Wait Calendar disappear");
        waitToElementsIsNotVisible(driver, 5, ProfilePageUI.YEAR_DATE_PICKER);
    }

    public void clickUpdateButton(){
        logger.info("Click Update button");
        clickElement(driver, ProfilePageUI.USER_SUBMIT_BUTTON);
    }

    public String getFirstNameErrorMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.FIRST_NAME_ERROR_MESSAGE);
        logger.info("Get FirstName error message" + actualResult);
        return actualResult;
    }

    public String getLastNameErrorMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.LAST_NAME_ERROR_MESSAGE);
        logger.info("Get LastName error message" + actualResult);
        return actualResult;
    }

    public String getSuccessMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.SUCCESS_MESSAGE);
        logger.info("Get success message" + actualResult);
        return actualResult;
    }

}
