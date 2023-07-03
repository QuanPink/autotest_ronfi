package io.ronfi.testCase;

import io.ronfi.base.Setup;
import io.ronfi.base.Utils;
import io.ronfi.page.ExtensionMetamask;
import io.ronfi.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends Setup {

    private final WebDriver driver;
    private ExtensionMetamask setupExtension;
    private Utils utils;
    private LoginPage login;

    public LoginTest() {
        driver = getDriver();
    }

    @BeforeSuite
    public void setupExtension() {
        setupExtension = new ExtensionMetamask();
        setupExtension.setupMetamask();
        utils = new Utils(driver);
        login = new LoginPage(driver);
    }

    @Test
    public void login() throws InterruptedException {
        utils.getTitle();
        utils.waitClick(login.connectWallet);
        utils.setThread();
        Assert.assertTrue(login.btnUserAccount.isDisplayed());
        utils.waitClick(login.switchToScreenStake);
    }
}
