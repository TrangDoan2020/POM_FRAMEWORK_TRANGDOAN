package vn.sendo.login;

import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;
import utils.ExcelUtils;
import utils.PropertiesUtils;

public class Login_02_SendoLogin extends AbstractTest {
    WebDriver driver;

    LoginPageObject loginPage;

//    String email01 = "trangdoan@mailinator.com";
//    String password01 ="";
//    //String expectedResult01 = "Vui lòng nhập mật khẩu đăng nhập.";
//
//    String email02 = "trangdoan@mailinator.com";
//    String password02 ="12345";
//    //String expectedResult02 = "Độ dài mật khẩu từ 6 đến 32 ký tự, vui lòng nhập lại.";
//
//    String email03 = "trangdoan@mailinator.com";
//    String password03 ="12345678abc";
//    //String expectedResult03 = "Sai mật khẩu hoặc tài khoản đăng nhập. Vui lòng nhập lại.";
//
    String email04 = "trangdoan@mailinator.com";
    String password04 ="12345678";

    String email05 = "0938586131";
    String password05 ="123456@";

    Wait<WebDriver> wait;

    @Parameters("browser")
    @BeforeClass
    public void beforeMethod(String browserValue){
        driver = getBrowserDriver(browserValue);

        maximizeWindow(driver);

        openUrl(driver, GlobalConstants.url);

        loginPage = new LoginPageObject(driver);

        loginPage.closeRedPopup();

        loginPage.closeWhitePopup();
    }

    @DataProvider
    public Object[][] invalidAccountData(){
        return ExcelUtils.readExcelValues("TC_InvalidAccounts");
    }

    @Test(dataProvider = "invalidAccountData")
    public void TC_InvalidAccounts(String email, String password, String message) {
        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email);

        loginPage.enterPasswordOnLoginPopup(password);

        loginPage.clickLoginButtonOnLoginPopup();

        String actualResult = loginPage.getErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue(message);

        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");

        loginPage.quitLoginPopup();
    }


    @Test
    public void TC_Login_04_LoginSuccessWithEmail() {

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email04);

        loginPage.enterPasswordOnLoginPopup(password04);

        loginPage.clickLoginButtonOnLoginPopup();

        boolean result = loginPage.isUserMenuDisplayed();

        Assert.assertTrue(result);

        loginPage.clickUserMenuOnTopBar();

        loginPage.clickQuitOnMenu();
    }

   @Test
    public void TC_Login_05_LoginSuccessWithPhoneNumber() {

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email05);

        loginPage.enterPasswordOnLoginPopup(password05);

        loginPage.clickLoginButtonOnLoginPopup();

        boolean result = loginPage.isUserMenuDisplayed();

        Assert.assertTrue(result);

        loginPage.clickUserMenuOnTopBar();

        loginPage.clickQuitOnMenu();
    }

    @AfterClass
    public void afterMethod(){
        closeBrowser(driver);
    }
}
