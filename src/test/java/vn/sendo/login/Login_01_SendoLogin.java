package vn.sendo.login;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.PropertiesUtils;

public class Login_01_SendoLogin extends AbstractTest {

    String email01 = "trangdoan@mailinator.com";
    String password01 ="";
    //String expectedResult01 = "Vui lòng nhập mật khẩu đăng nhập.";

    String email02 = "trangdoan@mailinator.com";
    String password02 ="12345";
    //String expectedResult02 = "Độ dài mật khẩu từ 6 đến 32 ký tự, vui lòng nhập lại.";

    String email03 = "trangdoan@mailinator.com";
    String password03 ="12345678abc";
    //String expectedResult03 = "Sai mật khẩu hoặc tài khoản đăng nhập. Vui lòng nhập lại.";

    String email04 = "trangdoan@mailinator.com";
    String password04 ="12345678";

    String email05 = "0938586131";
    String password05 ="123456@";

    Wait<WebDriver> wait;

    @Test
    public void TC_Login_01_EnterNoPassword(){

        logger.info("---TC_Login_01_EnterNoPassword---");

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email01);

        loginPage.enterPasswordOnLoginPopup(password01);

        loginPage.clickLoginButtonOnLoginPopup();

        String actualResult = loginPage.getErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("EMPTY_PASSWORD_ERROR_MESSAGE");

        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");

        loginPage.quitLoginPopup();
    }

    @Test
    public void TC_Login_02_EnterPasswordLessThan6Chars(){

        logger.info("---TC_Login_02_EnterPasswordLessThan6Chars---");

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email02);

        loginPage.enterPasswordOnLoginPopup(password02);

        loginPage.clickLoginButtonOnLoginPopup();

        String actualResult = loginPage.getErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("INVALID_LENGTH_PASSWORD_ERROR_MESSAGE");

        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");

        loginPage.quitLoginPopup();
    }

    @Test
    public void TC_Login_03_EnterWrongPassword() {

        logger.info("---TC_Login_03_EnterWrongPassword---");

        loginPage.clickLoginButtonOnTopBar();

        loginPage.clickHaveSendoIDLinkOnLoginPopup();

        loginPage.enterEmailOnLoginPopup(email03);

        loginPage.enterPasswordOnLoginPopup(password03);

        loginPage.clickLoginButtonOnLoginPopup();

        String actualResult = loginPage.getErrorMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("WRONG_PASSWORD_ERROR_MESSAGE");

        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");

        loginPage.quitLoginPopup();
    }

    @Test
    public void TC_Login_04_LoginSuccessWithEmail() {

        logger.info("---TC_Login_04_LoginSuccessWithEmail---");

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

        logger.info("---TC_Login_05_LoginSuccessWithPhoneNumber---");

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
}
