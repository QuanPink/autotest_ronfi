package io.ronfi.testCase;

import io.ronfi.base.Setup;
import io.ronfi.base.Utils;
import io.ronfi.page.StakePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    public void stake() throws InterruptedException {
        Assert.assertFalse(utils.checkEnable(stake.btnStake));
        utils.waitGetTextAndCompare(stake.inputToken, "    1");
        utils.sendSpecialCharacter(stake.inputToken, "!@#$%^&");
        utils.sendSpecialCharacter(stake.inputToken, "quan");
        utils.waitSenKey(stake.inputToken, "0.009");
        Assert.assertTrue(utils.checkEnable(stake.messageInputToken));
        Assert.assertFalse(utils.checkEnable(stake.btnStake));
        utils.clearData(stake.inputToken);
        utils.waitSenKey(stake.inputToken, "0.01");
        Assert.assertTrue(utils.checkEnable(stake.btnStake));
    }
}
