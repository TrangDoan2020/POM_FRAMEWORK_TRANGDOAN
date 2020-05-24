package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    public void closePopup01(WebDriver driver){
        closePopup(driver, LoginPageUI.POPUP_01);
    }

    public void closePopup02(WebDriver driver){
        closePopup(driver,LoginPageUI.POPUP_02);
    }

    public void clickLogin01(WebDriver driver){
        clickElement(driver,LoginPageUI.BTNLOGIN_01);
    }

    public void clickHaveSendoID(WebDriver driver){
        clickElement(driver,LoginPageUI.LNKSENDOID);
    }

    public void enterEmail(WebDriver driver, String email){
        setText(driver,LoginPageUI.TXTUSERNAME, email);
    }

    public void enterPassword(WebDriver driver, String password){
        setText(driver,LoginPageUI.TXTPASSWORD, password);
    }

    public void clickLogin02(WebDriver driver){
        clickElement(driver, LoginPageUI.BTNLOGIN_02);
    }

    public String verifyErrorMessage(WebDriver driver){
        String actualResult = getTextElement(driver, LoginPageUI.ERRORMESSAGE);
        return actualResult;
    }

    public boolean verifyUserMenu(WebDriver driver){
        boolean result = isElementDisplayed(driver,LoginPageUI.USER_MENU);
        return result;
    }
}
