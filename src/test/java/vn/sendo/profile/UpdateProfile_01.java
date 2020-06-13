package vn.sendo.profile;

import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.ProfilePageObject;
import utils.PropertiesUtils;

public class UpdateProfile_01 extends AbstractTest {

    WebDriver driver;

    LoginPageObject loginPage;
    ProfilePageObject profilePage;

    String email = "trangdoan@mailinator.com";
    String password ="12345678";

    String imagePath = GlobalConstants.projectPath + "\\src\\main\\resources\\comayman.jpg";
    String firstName1 = "";
    String lastName1 = "Xuân Như Ý";

    String firstName2 = "Đặng Ngọc";
    String lastName2 = "";

    String firstName3 = "Đặng Ngọc";
    String lastName3 = "Xuân Như Ý";

    String gender = "Nữ";
    String day = "15";
    String month = "Tháng 6";
    String year = "1997";

    @Parameters("browser")
    @BeforeClass
    public void beforeMethod(String browserValue){
        driver = getBrowserDriver(browserValue);

        maximizeWindow(driver);

        openUrl(driver, GlobalConstants.url);

        loginPage = new LoginPageObject(driver);
        profilePage = new ProfilePageObject(driver);
    }

    @Test
    public void TC_Login_01_SuccessLogin(){
        loginPage.closeRedPopup();

        loginPage.closeWhitePopup();

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email);

        loginPage.enterPasswordOnLoginPopup(password);

        loginPage.clickLoginButtonOnLoginPopup();

        boolean result = loginPage.isUserMenuDisplayed();

        Assert.assertTrue(result);
    }

    @Test (dependsOnMethods = "TC_Login_01_SuccessLogin")
    public void TC_Profile_01_EmptyFirstName(){
        profilePage.clickUserMenu();
        profilePage.clickAccountInfoFromMenu();
        profilePage.clickAvatar();
        profilePage.clickChoosePhotoButtonOnPopup();
        profilePage.selectAPhotoFromComputer(imagePath);
        profilePage.clickUploadSubmitButtonOnPopup();
        profilePage.waitUploadPopupDisappear();
        profilePage.clearFirstNameTextbox();
        profilePage.enterFirstNameIntoTextbox(firstName1);
        profilePage.clearLastNameTextbox();
        profilePage.enterLastNameIntoTextbox(lastName1);
        profilePage.checkGender(gender);
        profilePage.clickBirthdayDatePicker();
        profilePage.selectMonthFromDatePicker(month);
        profilePage.selectYearFromDatePicker(year);
        profilePage.selectDayFromDatePicker(day);
        profilePage.waitCalendarDisappear();
        profilePage.clickUpdateButton();
        String actualResult = profilePage.getFirstNameErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("EMPTY_FIRST_NAME_ERROR_MESSAGE");
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Test (dependsOnMethods = "TC_Login_01_SuccessLogin")
    public void TC_Profile_02_EmptyLastName(){
        profilePage.clickUserMenu();
        profilePage.clickAccountInfoFromMenu();
        profilePage.clickAvatar();
        profilePage.clickChoosePhotoButtonOnPopup();
        profilePage.selectAPhotoFromComputer(imagePath);
        profilePage.clickUploadSubmitButtonOnPopup();
        profilePage.waitUploadPopupDisappear();
        profilePage.clearFirstNameTextbox();
        profilePage.enterFirstNameIntoTextbox(firstName2);
        profilePage.clearLastNameTextbox();
        profilePage.enterLastNameIntoTextbox(lastName2);
        profilePage.checkGender(gender);
        profilePage.clickBirthdayDatePicker();
        profilePage.selectMonthFromDatePicker(month);
        profilePage.selectYearFromDatePicker(year);
        profilePage.selectDayFromDatePicker(day);
        profilePage.waitCalendarDisappear();
        profilePage.clickUpdateButton();
        String actualResult = profilePage.getLastNameErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("EMPTY_LAST_NAME_ERROR_MESSAGE");
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Test (dependsOnMethods = "TC_Login_01_SuccessLogin")
    public void TC_Profile_03_UpdateSuccessProfile(){
        profilePage.clickUserMenu();
        profilePage.clickAccountInfoFromMenu();
        profilePage.clickAvatar();
        profilePage.clickChoosePhotoButtonOnPopup();
        profilePage.selectAPhotoFromComputer(imagePath);
        profilePage.clickUploadSubmitButtonOnPopup();
        profilePage.waitUploadPopupDisappear();
        profilePage.clearFirstNameTextbox();
        profilePage.enterFirstNameIntoTextbox(firstName3);
        profilePage.clearLastNameTextbox();
        profilePage.enterLastNameIntoTextbox(lastName3);
        profilePage.checkGender(gender);
        profilePage.clickBirthdayDatePicker();
        profilePage.selectMonthFromDatePicker(month);
        profilePage.selectYearFromDatePicker(year);
        profilePage.selectDayFromDatePicker(day);
        profilePage.waitCalendarDisappear();
        profilePage.clickUpdateButton();
        String actualResult = profilePage.getSuccessMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("UPDATE_SUCCESS_PROFILE_MESSAGE");
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @AfterClass
    public void afterMethod(){
        closeBrowser(driver);
    }
}
