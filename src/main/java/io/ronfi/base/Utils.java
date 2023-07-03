package io.ronfi.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private static final int WAIT_TIMEOUT_SECONDS = 30;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        this.actions = new Actions(driver);
    }

    public void setThread() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void waitLoadPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public void waitSenKey(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
    }

    public void waitClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitAction(WebElement element, String value) {
        WebElement action = wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.sendKeys(action, value).sendKeys(Keys.ENTER).build().perform();
    }

    public boolean checkTrimSpace(WebElement element) {
        String text = element.getAttribute("value");
        String trimmedText = text.trim();
        return text.equals(trimmedText);
    }

    public boolean checkTrimAll(WebElement element) {
        String text = element.getAttribute("value");
        return text.isEmpty();
    }

    public void clearData(WebElement element) {
        element.clear();
    }

    public boolean checkEnable(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    public boolean checkDisplayed(WebElement element, String value) {
        String pageText = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        return pageText.contains(value);
    }

    public void validate(WebElement element, WebElement element1) {
        String allToken = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        WebElement inputC = wait.until(ExpectedConditions.visibilityOf(element1));
        double numericValue = Double.parseDouble(allToken);
        double subtractedValue = numericValue - 0.001;
        String newValue = String.valueOf(subtractedValue);
        inputC.sendKeys(newValue);
    }

    public void switchToNewWindow(int value) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(value));
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    public void switchToOriginalWindow(int value) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(value));
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }
}
