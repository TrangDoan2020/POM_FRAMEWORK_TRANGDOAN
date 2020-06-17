package pageObjects;

import commons.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    Logger logger = Logger.getLogger(LoginPageObject.class.getSimpleName());

    public LoginPageObject(WebDriver _driver){
        driver = _driver;
    }

    public void closeRedPopup(){
        logger.info("Closed red popup");
        closePopup(driver, LoginPageUI.RED_POPUP);
    }

    public void closeWhitePopup(){
        logger.info("Closed white popup");
        closePopup(driver,LoginPageUI.WHITE_POPUP);
    }

    public void clickLoginButtonOnTopBar(){
        logger.info("Click Login button on top bar");
        clickElement(driver,LoginPageUI.BTN_LOGIN_ON_TOP_BAR);
    }

    public void clickHaveSendoIDLinkOnLoginPopup(){
        logger.info("Click Have Sendo ID link on Login popup");
        clickElement(driver,LoginPageUI.LNKSENDOID);
    }

    public void enterEmailOnLoginPopup(String email){
        logger.info("Enter Email: " + email +  " on Login popup");
        setText(driver,LoginPageUI.TXTUSERNAME, email);
    }

    public void enterPasswordOnLoginPopup(String password){
        logger.info("Enter Password " + password + " on Login popup");
        setText(driver,LoginPageUI.TXTPASSWORD, password);
    }

    public void clickLoginButtonOnLoginPopup(){
        logger.info("Click Login button on Login popup");
        clickElement(driver, LoginPageUI.BTN_LOGIN_ON_LOGIN_POPUP);
    }

    public String getErrorMessage(){
        String actualResult = getTextElement(driver, LoginPageUI.ERRORMESSAGE);
        logger.info("Get error message" + actualResult);
        return actualResult;
    }

    public boolean isUserMenuDisplayed(){
        boolean result = isElementDisplayed(driver,LoginPageUI.USER_MENU);
        logger.info("Is User menu displayed" + result);
        return result;
    }

    public void quitLoginPopup(){
        logger.info("Quit Login popup");
        clickElement(driver,LoginPageUI.QUIT_BUTTON);
    }

    public void clickUserMenuOnTopBar(){
        logger.info("Click User menu on top bar");
        clickElement(driver,LoginPageUI.USER_MENU);
    }

    public void clickQuitOnMenu(){
        logger.info("Click Quit on Menu");
        clickElement(driver,String.format(LoginPageUI.ITEM_ON_MENU,"Thoát"));
    }
}
