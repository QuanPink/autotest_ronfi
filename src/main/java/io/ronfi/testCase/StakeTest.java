package io.ronfi.testCase;

import io.ronfi.base.Setup;
import io.ronfi.base.Utils;
import io.ronfi.page.StakePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class StakeTest extends Setup {
    private final WebDriver driver;
    public Utils utils;
    public StakePage stake;

    public StakeTest() {
        driver = getDriver();
        utils = new Utils(driver);
        stake = new StakePage(driver);
    }

    @Test
    public void stake() {
        driver.navigate().to("https://testnet.ronfi.io/stake");
//        Assert.assertFalse(utils.checkEnable(stake.btnStake));
        utils.waitGetTextAndCompare(stake.inputToken, "1");
    }
}
