package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
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
