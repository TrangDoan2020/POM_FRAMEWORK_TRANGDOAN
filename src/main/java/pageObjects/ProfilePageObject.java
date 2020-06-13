package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.ProfilePageUI;

public class ProfilePageObject extends AbstractPage {
    WebDriver driver;

    public ProfilePageObject(WebDriver _driver){
        driver = _driver;
    }

    public void clickUserMenu(){
        clickElement(driver, ProfilePageUI.USER_MENU);
    }

    public void clickAccountInfoFromMenu(){
        clickElement(driver, String.format(ProfilePageUI.ITEM_ON_MENU, "Thông tin tài khoản"));
    }

    public void clickAvatar(){
        clickElement(driver, ProfilePageUI.CHANGE_AVATAR_BUTTON);
    }

    public void clickChoosePhotoButtonOnPopup(){
        clickElement(driver, ProfilePageUI.CHOOSE_PHOTO_FROM_COMPUTER_BUTTON);
    }

    public void selectAPhotoFromComputer(String filePath){
        uploadFileWithRobot(filePath);
    }

    public void clickUploadSubmitButtonOnPopup(){
        clickElement(driver, ProfilePageUI.UPLOAD_SUBMIT_BUTTON);
    }

    public void waitUploadPopupDisappear(){
        waitToElementsIsNotVisible(driver, 5, ProfilePageUI.UPLOAD_SUBMIT_BUTTON);
    }

    public void clearFirstNameTextbox(){
        clearText(driver, ProfilePageUI.FIRST_NAME_TEXTBOX);
    }

    public void enterFirstNameIntoTextbox(String firstName){
        setText(driver, ProfilePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void clearLastNameTextbox(){
        clearText(driver, ProfilePageUI.LAST_NAME_TEXTBOX);
    }

    public void enterLastNameIntoTextbox(String lastName){
        setText(driver, ProfilePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void checkGender(String gender){
        clickElement(driver, String.format(ProfilePageUI.GENDER_CHECKBOX, gender));

    }

    public void clickBirthdayDatePicker(){
        clickElement(driver, ProfilePageUI.BIRTHDAY_DATE_PICKER);
    }

    public void selectDayFromDatePicker(String day){
        clickElement(driver, String.format(ProfilePageUI.DAY_DATE_PICKER, day));
    }

    public void selectMonthFromDatePicker(String month){
        WebElement element = findElementByXpath(driver, ProfilePageUI.MONTH_DATE_PICKER);
        selectOptionFromDropdown(element, month);
    }

    public void selectYearFromDatePicker(String year){
        WebElement element = findElementByXpath(driver, ProfilePageUI.YEAR_DATE_PICKER);
        selectOptionFromDropdown(element, year);
    }

    public void waitCalendarDisappear(){
        waitToElementsIsNotVisible(driver, 5, ProfilePageUI.YEAR_DATE_PICKER);
    }

    public void clickUpdateButton(){
        clickElement(driver, ProfilePageUI.USER_SUBMIT_BUTTON);
    }

    public String getFirstNameErrorMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.FIRST_NAME_ERROR_MESSAGE);
        return actualResult;
    }

    public String getLastNameErrorMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.LAST_NAME_ERROR_MESSAGE);
        return actualResult;
    }

    public String getSuccessMessage(){
        String actualResult = getTextElement(driver, ProfilePageUI.SUCCESS_MESSAGE);
        return actualResult;
    }

}
