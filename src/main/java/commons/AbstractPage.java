package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {
    WebDriverWait wait;

    String projectPath = System.getProperty("user.dir");
    String resourcesFolder = projectPath + "/src/main/resources/";

    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void openUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public WebDriver getBrowserDriver(String browserValue){
        WebDriver driver = null;

        if(browserValue.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", resourcesFolder + "chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserValue.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", resourcesFolder + "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void closeBrowser(WebDriver driver){
        driver.close();
    }

    public void waitToElementVisible(WebDriver driver, long timeOuts, String locator){
        wait = new WebDriverWait(driver, timeOuts);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitToElementsVisible(WebDriver driver, long timeOuts, String locator){
        wait = new WebDriverWait(driver, timeOuts);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public WebElement findElementByXpath(WebDriver driver, String locator){
        waitToElementVisible(driver,20,locator);
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> findElementsByXpath (WebDriver driver, String locator){
        waitToElementsVisible(driver,20, locator);
        return driver.findElements(By.xpath(locator));
    }

    public void clickElement(WebDriver driver, String locator){
        findElementByXpath(driver, locator).click();
    }

    public void setText(WebDriver driver, String locator, String value){
        findElementByXpath(driver, locator).sendKeys(value);
    }

    public String getTextElement(WebDriver driver, String locator){
        return findElementByXpath(driver, locator).getText();
    }

    public void closePopup(WebDriver driver, String locator){
        List<WebElement> elements = findElementsByXpath(driver,locator);
        if (elements.size() > 0){
            elements.get(0).click();
        }
    }

}
