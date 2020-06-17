package commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.LoginPageObject;
import pageObjects.ProfilePageObject;
import pageObjects.ShippingAddressObject;

public class AbstractTest {
    WebDriver driver;

    protected LoginPageObject loginPage;
    protected ProfilePageObject profilePage;
    protected ShippingAddressObject shippingAddressPage;

    protected Logger logger = Logger.getLogger(AbstractTest.class.getSimpleName());

    @Parameters("browser")
    @BeforeClass
    public void beforeMethod(String browserValue, ITestContext context){
        driver = getBrowserDriver(browserValue);
        context.setAttribute("webDriver", driver);

        maximizeWindow(driver);

        openUrl(driver, GlobalConstants.url);

        loginPage = new LoginPageObject(driver);
        profilePage = new ProfilePageObject(driver);
        shippingAddressPage = new ShippingAddressObject(driver);

        loginPage.closeRedPopup();

        loginPage.closeWhitePopup();
    }

    @AfterClass
    public void afterMethod(){
        closeBrowser(driver);
    }

    public WebDriver getBrowserDriver(String browserValue){
        WebDriver driver = null;

        if(browserValue.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", GlobalConstants.resourcesFolder + "chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserValue.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", GlobalConstants.resourcesFolder + "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void closeBrowser(WebDriver driver){
        driver.close();
    }

    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void openUrl(WebDriver driver, String url){
        driver.get(url);
    }
}
