package vn.sendo.shippingAddress;

import commons.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesUtils;

public class UpdateShippingAddress_01 extends AbstractTest {

    String email = "trangdoan@mailinator.com";
    String password ="12345678";

    String firstName = "Nguyễn";
    String lastName = "Hà Ngọc Hân";
    String address = "Tòa nhà Pasteur Tower, 139 Pasteur";
    String city = "Hà Nội";
    String district = "Huyện Ba Vì";
    String ward = "Thị trấn Tây Đằng";
    String phoneNumber = "0908070605";

    @Test
    public void TC_Login_01_SuccessLogin(){

        logger.info("---TC_Login_01_SuccessLogin---");

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
        logger.info("---TC_Profile_UpdateShippingAddress_01_UpdateSuccessShippingAddress---");
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
}
