package io.ronfi.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class Utils {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        this.actions = new Actions(driver);
    }

    public void setThread() throws InterruptedException {
        Thread.sleep(2000);
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

    public String waitGetText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public boolean checkEnable(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    public void waitLoadPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    public void waitSwitchToWindow() {
        int screenCount = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length;
        if (screenCount == 1) {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }
        } else {
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
