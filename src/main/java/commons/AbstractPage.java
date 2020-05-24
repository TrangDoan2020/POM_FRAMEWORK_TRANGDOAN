package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {
    WebDriverWait wait;

    // Wait Element
    public void waitToElementVisible(WebDriver driver, long timeOuts, String locator){
        wait = new WebDriverWait(driver, timeOuts);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitToElementsVisible(WebDriver driver, long timeOuts, String locator){
        wait = new WebDriverWait(driver, timeOuts);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }

    // Find Elements
    public WebElement findElementByXpath(WebDriver driver, String locator){
        waitToElementVisible(driver,20,locator);
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> findElementsByXpath (WebDriver driver, String locator){
        waitToElementsVisible(driver,20, locator);
        return driver.findElements(By.xpath(locator));
    }

    // Actions
    public void clickElement(WebDriver driver, String locator){
        findElementByXpath(driver, locator).click();
    }

    public void setText(WebDriver driver, String locator, String value){
        findElementByXpath(driver, locator).sendKeys(value);
    }

    // Get text
    public String getTextElement(WebDriver driver, String locator){
        return findElementByXpath(driver, locator).getText();
    }

    // Others
    public void closePopup(WebDriver driver, String locator){
        List<WebElement> elements = findElementsByXpath(driver,locator);
        if (elements.size() > 0){
            elements.get(0).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator){
        return findElementByXpath(driver,locator).isDisplayed();
    }

}
