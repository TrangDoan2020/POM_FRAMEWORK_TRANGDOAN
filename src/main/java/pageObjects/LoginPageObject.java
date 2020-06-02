package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

    WebDriver driver;

    public LoginPageObject(WebDriver _driver){
        driver = _driver;
    }

    public void closeRedPopup(){
        closePopup(driver, LoginPageUI.RED_POPUP);
    }

    public void closeWhitePopup(){
        closePopup(driver,LoginPageUI.WHITE_POPUP);
    }

    public void clickLoginButtonOnTopBar(){
        clickElement(driver,LoginPageUI.BTN_LOGIN_ON_TOP_BAR);
    }

    public void clickHaveSendoIDLinkOnLoginPopup(){
        clickElement(driver,LoginPageUI.LNKSENDOID);
    }

    public void enterEmailOnLoginPopup(String email){
        setText(driver,LoginPageUI.TXTUSERNAME, email);
    }

    public void enterPasswordOnLoginPopup(String password){
        setText(driver,LoginPageUI.TXTPASSWORD, password);
    }

    public void clickLoginButtonOnLoginPopup(){
        clickElement(driver, LoginPageUI.BTN_LOGIN_ON_LOGIN_POPUP);
    }

    public String getErrorMessage(){
        String actualResult = getTextElement(driver, LoginPageUI.ERRORMESSAGE);
        return actualResult;
    }

    public boolean isUserMenuDisplayed(){
        boolean result = isElementDisplayed(driver,LoginPageUI.USER_MENU);
        return result;
    }

    public void quitLoginPopup(){
        clickElement(driver,LoginPageUI.QUIT_BUTTON);
    }

    public void clickUserMenuOnTopBar(){
        clickElement(driver,LoginPageUI.USER_MENU);
    }

    public void clickQuitOnMenu(){
        clickElement(driver,String.format(LoginPageUI.ITEM_ON_MENU,"Thoát"));
    }

}
