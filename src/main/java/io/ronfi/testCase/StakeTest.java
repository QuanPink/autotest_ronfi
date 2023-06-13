package io.ronfi.testCase;

import io.ronfi.base.Setup;
import io.ronfi.base.Utils;
import io.ronfi.page.MetamaskPage;
import io.ronfi.page.StakePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StakeTest extends Setup {
    private final WebDriver driver;
    private final Utils utils;
    private final StakePage stake;

    private final MetamaskPage metamaskPage;

    public StakeTest() {
        driver = getDriver();
        utils = new Utils(driver);
        stake = new StakePage(driver);
        metamaskPage = new MetamaskPage(driver);
    }

    @Test
    public void stake() throws InterruptedException {
        Assert.assertFalse(utils.checkEnable(stake.btnStake));
        utils.setThread();
        utils.waitSenKey(stake.inputToken, "    1");
        Assert.assertTrue(utils.checkTrimSpace(stake.inputToken));
        utils.clearData(stake.inputToken);
        utils.waitSenKey(stake.inputToken, "!@#$%^&");
        Assert.assertTrue(utils.checkTrimAll(stake.inputToken));
        utils.waitSenKey(stake.inputToken, "quan");
        Assert.assertTrue(utils.checkTrimAll(stake.inputToken));
        utils.waitSenKey(stake.inputToken, "0.009");
        Assert.assertTrue(utils.checkDisplayed(stake.messageInputToken, "Minimum amount is 0.01 RON"));
        Assert.assertFalse(utils.checkEnable(stake.btnStake));
        utils.clearData(stake.inputToken);
        utils.waitSenKey(stake.inputToken, "0.01");
        Assert.assertFalse(utils.checkDisplayed(stake.allPage, "Minimum amount is 0.01 RON"));
        Assert.assertTrue(utils.checkEnable(stake.btnStake));
        utils.waitClick(stake.btnStake);
        utils.switchToNewWindow(2);
        utils.waitClick(metamaskPage.cancel);
        utils.switchToOriginalWindow(1);
        utils.waitClick(stake.btnStake);
        utils.switchToNewWindow(2);
        utils.waitClick(metamaskPage.confirm);
    }
}
