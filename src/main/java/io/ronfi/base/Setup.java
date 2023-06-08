package io.ronfi.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Setup {
    private static WebDriver driver;
    private static ChromeOptions options;

    public Setup() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            options = new ChromeOptions();
            options.addExtensions(new File("extension/Ronin-Wallet.crx"));
            driver = new ChromeDriver(options);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
