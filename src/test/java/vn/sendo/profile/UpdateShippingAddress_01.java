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
import pageObjects.ShippingAddressObject;
import utils.PropertiesUtils;

public class UpdateShippingAddress_01 extends AbstractTest {
    WebDriver driver;

    LoginPageObject loginPage;
    ShippingAddressObject shippingAddressPage;

    String email = "trangdoan@mailinator.com";
    String password ="12345678";

    String firstName = "Nguyễn";
    String lastName = "Hà Ngọc Hân";
    String address = "Tòa nhà Pasteur Tower, 139 Pasteur";
    String city = "Hà Nội";
    String district = "Huyện Ba Vì";
    String ward = "Thị trấn Tây Đằng";
    String phoneNumber = "0908070605";

    @Parameters("browser")
    @BeforeClass
    public void beforeMethod(String browserValue){
        driver = getBrowserDriver(browserValue);

        maximizeWindow(driver);

        openUrl(driver, GlobalConstants.url);

        loginPage = new LoginPageObject(driver);
        shippingAddressPage = new ShippingAddressObject(driver);
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
    public void TC_Profile_UpdateShippingAddress_01_UpdateSuccessShippingAddress() {
        shippingAddressPage.clickUserMenu();
        shippingAddressPage.clickAccountInfoFromMenu();
        shippingAddressPage.clickShippingAddressLink();
        shippingAddressPage.clickEditButton();
        shippingAddressPage.clearFirstNameTextbox();
        shippingAddressPage.enterFirstNameIntoTextbox(firstName);
        shippingAddressPage.clearLastNameTextbox();
        shippingAddressPage.enterLastNameIntoTextbox(lastName);
        shippingAddressPage.clearAddressTextbox();
        shippingAddressPage.enterAddressIntoTextbox(address);
        shippingAddressPage.selectCity(city);
        shippingAddressPage.selectDistrict(district);
        shippingAddressPage.selectWard(ward);
        shippingAddressPage.clearPhoneNumberTextbox();
        shippingAddressPage.enterPhoneNumberIntoTextbox(phoneNumber);
        shippingAddressPage.clickAddressSubmitButton();
        String actualResult = shippingAddressPage.getSuccessMessage();
        System.out.println(actualResult);
        String expectedResult = PropertiesUtils.readPropertiesValue("UPDATE_SUCCESS_SHIPPING_ADDRESS_MESSAGE");
        Assert.assertEquals(actualResult, expectedResult,"Error message is not matched!");

    }
    //@Test
    public void TC_Profile_UpdateShippingAddress_02_EmptyLastName(){

    }

    @AfterClass
    public void afterMethod(){
        closeBrowser(driver);
    }
}
