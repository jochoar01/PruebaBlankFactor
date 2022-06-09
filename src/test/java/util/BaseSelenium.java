package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseSelenium {


    private WebDriver driver;


    public BaseSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver conexionConChrome() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        return driver;

    }

    public WebElement findElement(By locator) {

        return driver.findElement(locator);

    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);

    }

    public String getText(WebElement Element) {

        return Element.getText();
    }

    public String getText(By Element) {
        wait(Element);

        return findElement(Element).getText();
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = findElement(element);
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

    public void scrollElement(By Element) {
        WebElement element = driver.findElement(Element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


    }


    public void type(By locator, String inputText) {

        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        wait(locator);
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator) {

        try {

            return driver.findElement(locator).isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public void visit(String url) {

        driver.get(url);
    }

    public void close() {

        driver.quit();
    }

    public String getURL() {

        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {

        return driver;
    }

    public void returnPage() {

        driver.navigate().back();


    }

    public List<WebElement> getElementList(By selector) {
        return driver.findElements(selector);
    }
}
