package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

    public void waitToElementsIsNotVisible(WebDriver driver, long timeOuts, String locator){
        wait = new WebDriverWait(driver, timeOuts);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
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

    public void clickElements(WebDriver driver, String locator){
        List<WebElement> btnEdit = findElementsByXpath(driver, locator);
        if (btnEdit.size()>0){
            btnEdit.get(1).click();
        }
    }

    public void setText(WebDriver driver, String locator, String value){
        findElementByXpath(driver, locator).sendKeys(value);
    }

    // Get text
    public String getTextElement(WebDriver driver, String locator){
        return findElementByXpath(driver, locator).getText();
    }

    // Clear Text
    public void clearText(WebDriver driver, String locator){
        findElementByXpath(driver, locator).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
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

    public void uploadFileWithRobot (String filePath) {
        System.out.println(filePath);
        try {
            Thread.sleep(1000);
            StringSelection stringSelection = new StringSelection(filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            Robot robot = null;

            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {

        }
    }

    public void selectOptionFromDropdown(WebElement element, String optionvalue){
        Select select = new Select(element);
        select.selectByVisibleText(optionvalue);
    }
}
