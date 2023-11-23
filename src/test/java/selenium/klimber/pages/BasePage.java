package selenium.klimber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Properties urls = new Properties();
    Properties user = new Properties();
    Properties insurance = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            urls.load(new FileInputStream("src/test/resources/properties/urls.properties"));
            user.load(new FileInputStream("src/test/resources/properties/user.properties"));
            insurance.load(new FileInputStream("src/test/resources/properties/insurance.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    public boolean isPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void click(By locator) {
        wait.until(ExpectedConditions.visibilityOf(webElement(locator)));
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement(locator)));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOf(webElement(locator)));
        return webElement(locator).getText();
    }

    public String getValue(By locator) {
        wait.until(ExpectedConditions.visibilityOf(webElement(locator)));
        return webElement(locator).getAttribute("value");
    }

    public Boolean isChecked(By locator) {
        return webElement(locator).isSelected();
    }

    public Boolean isEmpty(By locator) {
        return webElement(locator).getAttribute("value").isEmpty();
    }

}
