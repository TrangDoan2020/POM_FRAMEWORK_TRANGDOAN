package vn.sendo.login;

import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;

public class Login_01_SendoLogin extends AbstractTest {
    WebDriver driver;

    LoginPageObject login = new LoginPageObject();

    String email01 = "trangdoan@mailinator.com";
    String password01 ="";

    String email02 = "trangdoan@mailinator.com";
    String password02 ="12345";

    String email03 = "trangdoan@mailinator.com";
    String password03 ="12345678abc";

    String email04 = "trangdoan@mailinator.com";
    String password04 ="12345678";

    Wait<WebDriver> wait;

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browserValue){
        driver = getBrowserDriver(browserValue);

        maximizeWindow(driver);

        openUrl(driver, GlobalConstants.url);
    }

    @Test
    public void TC_Login_01_EnterNoPassword(){
        login.closePopup01(driver);

        login.closePopup02(driver);

        login.clickLogin01(driver);

        login.clickHaveSendoID(driver);

        login.enterEmail(driver,email01);

        login.enterPassword(driver,password01);

        login.clickLogin02(driver);

        String actualResult = login.verifyErrorMessage(driver);
        System.out.println(actualResult);

        String expectedResult = "Vui lòng nhập mật khẩu đăng nhập.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Test
    public void TC_Login_02_EnterPasswordLessThan6Chars(){
        login.closePopup01(driver);

        login.closePopup02(driver);

        login.clickLogin01(driver);

        login.clickHaveSendoID(driver);

        login.enterEmail(driver,email02);

        login.enterPassword(driver,password02);

        login.clickLogin02(driver);

        String actualResult = login.verifyErrorMessage(driver);
        System.out.println(actualResult);

        String expectedResult = "Độ dài mật khẩu từ 6 đến 32 ký tự, vui lòng nhập lại.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Test
    public void TC_Login_03_EnterWrongPassword() {
        login.closePopup01(driver);

        login.closePopup02(driver);

        login.clickLogin01(driver);

        login.clickHaveSendoID(driver);

        login.enterEmail(driver,email03);

        login.enterPassword(driver,password03);

        login.clickLogin02(driver);

        String actualResult = login.verifyErrorMessage(driver);
        System.out.println(actualResult);

        String expectedResult = "Sai mật khẩu hoặc tài khoản đăng nhập. Vui lòng nhập lại.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Test
    public void TC_Login_04_EnterValidPassword() {
        login.closePopup01(driver);

        login.closePopup02(driver);

        login.clickLogin01(driver);

        login.clickHaveSendoID(driver);

        login.enterEmail(driver,email04);

        login.enterPassword(driver,password04);

        login.clickLogin02(driver);

        boolean result = login.verifyUserMenu(driver);

        Assert.assertTrue(result);
    }

    @AfterMethod
    public void afterMethod(){
        closeBrowser(driver);
    }
}
