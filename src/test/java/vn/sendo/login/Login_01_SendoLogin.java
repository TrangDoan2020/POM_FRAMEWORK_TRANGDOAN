package vn.sendo.login;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_01_SendoLogin extends AbstractPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browserValue){
        // Launch browser
        driver = getBrowserDriver(browserValue);

        //Open maximize window
        maximizeWindow(driver);

        // Pre-condition: Vào trang sendo.vn
        openUrl(driver,"https://sendo.vn");
    }

    @Parameters({"email_1", "password_1"})
    @Test
    public void TC_Login_01_EnterNoPassword(String emailValue, String passwordValue){
        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        closePopup(driver,"//div[@class='modal-content']/button[starts-with(@class,'close')]");

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        closePopup(driver,"//button[starts-with(@class,'closeBtn')]");

        // Step 3: Click Đăng nhập
        clickElement(driver,"//button[@id='login']");

        // Step 4: Click link "Đã có SendoID"
        clickElement(driver,"//span[text()='Đã có SendoID']");

        // Step 5: Nhập textbox Email
        setText(driver,"//input[@name='username']", emailValue);

        // Step 6: Nhập text Pass
        setText(driver,"//input[@name='password']", passwordValue);

        // Step 7: Click button Đăng nhập
        clickElement(driver, "//button[starts-with(@class,'btnLogin')]");

        // Step 8: Get error text
        String actualResult = getTextElement(driver, "//p[starts-with(@class,'error')]");
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Vui lòng nhập mật khẩu đăng nhập.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Parameters({"email_2" , "password_2"})
    @Test
    public void TC_Login_02_EnterPasswordLessThan6Chars(String emailValue, String passwordValue){
        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        closePopup(driver,"//div[@class='modal-content']/button[starts-with(@class,'close')]");

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        closePopup(driver, "//button[starts-with(@class,'closeBtn')]");

        // Step 3: Click Đăng nhập
        clickElement(driver, "//button[@id='login']");

        // Step 4: Click link "Đã có SendoID"
        clickElement(driver,"//span[text()='Đã có SendoID']");

        // Step 5: Nhập textbox Email
        setText(driver,"//input[@name='username']", emailValue);

        // Step 6: Nhập text Pass
        setText(driver,"//input[@name='password']", passwordValue);

        // Step 7: Click button Đăng nhập
        clickElement(driver, "//button[starts-with(@class,'btnLogin')]");

        // Step 8: Get error text
        String actualResult = getTextElement(driver, "//p[starts-with(@class,'error')]");
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Độ dài mật khẩu từ 6 đến 32 ký tự, vui lòng nhập lại.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @Parameters({"email_3" , "password_3"})
    @Test
    public void TC_Login_03_EnterWrongPassword(String emailValue, String passwordValue) {
        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        closePopup(driver,"//div[@class='modal-content']/button[starts-with(@class,'close')]");

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        closePopup(driver,"//button[starts-with(@class,'closeBtn')]");

        // Step 3: Click Đăng nhập
        clickElement(driver,"//button[@id='login']");

        // Step 4: Click link "Đã có SendoID"
        clickElement(driver,"//span[text()='Đã có SendoID']");

        // Step 5: Nhập textbox Email
        setText(driver,"//input[@name='username']", emailValue);

        // Step 6: Nhập text Pass
        setText(driver,"//input[@name='password']", passwordValue);

        // Step 7: Click button Đăng nhập
        clickElement(driver, "//button[starts-with(@class,'btnLogin')]");

        // Step 8: Get error text
        String actualResult = getTextElement(driver, "//p[starts-with(@class,'error')]");
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Sai mật khẩu hoặc tài khoản đăng nhập. Vui lòng nhập lại.";
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");
    }

    @AfterMethod
    public void afterMethod(){
        // Post-condition: Đóng trình duyệt
        closeBrowser(driver);
    }
}
