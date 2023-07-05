package io.ronfi.page;

import io.ronfi.base.Setup;
import io.ronfi.base.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtensionMetamask extends Setup {
    @FindBy(xpath = "//button[contains(text(), 'Get Started')]")
    WebElement btnGetStarted;
    @FindBy(xpath = "//div[text() = 'I already have a secret recovery phrase. Import wallet.']")
    WebElement btnConfirmImport;
    @FindBy(xpath = "//div[text() = 'Allow tracking']")
    WebElement btnAllow;
    @FindBy(className = "ds-input")
    WebElement inputKeys;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div/label[2]/div/div/span/input")
    WebElement inputPass;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div/label[3]/div/div/span/input")
    WebElement inputPassConfirm;
    @FindBy(xpath = "//button[contains(text(), 'Import wallet')]")
    WebElement btnImportWallet;
    @FindBy(className = "ds-input")
    WebElement input;
    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/div[1]/button")
    WebElement menu;
    @FindBy(xpath = "//div[text() = 'Settings']")
    WebElement setting;
    @FindBy(xpath = "//div[text() = 'here']")
    WebElement click;
    @FindBy(xpath = "//span[@class = 'ds-switch-transition']")
    WebElement switchNetwork;
    @FindBy(xpath = "//div[text() = 'Sure']")
    WebElement accept;
    @FindBy(xpath = "//span[text() = 'Ronin Network']")
    WebElement roninNetwork;
    @FindBy(xpath = "//span[text() = 'Saigon Testnet']")
    WebElement saigonNetwork;
    private final WebDriver driver;
    private final Utils utils;

    public ExtensionMetamask() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    public void setupMetamask() {
        driver.get("chrome-extension://fnjhmkhhmkbjkkabndcnnogagogbneec/popup.html#/unlock");
        utils.waitClick(btnGetStarted);
        utils.switchToWindow(2);
        utils.waitClick(btnConfirmImport);
        utils.waitClick(btnAllow);
        utils.waitSenKey(inputKeys, "hat blossom online runway wrist father cash pumpkin float kit angle jump");
        utils.waitSenKey(inputPass, "123123123");
        utils.waitSenKey(inputPassConfirm, "123123123");
        utils.waitClick(btnImportWallet);
        driver.close();
        utils.switchToWindow(1);
        driver.navigate().refresh();
        utils.waitAction(input, "123123123");
        utils.waitClick(menu);
        utils.waitClick(setting);
        utils.waitClick(click);
        utils.waitClick(switchNetwork);
        utils.waitClick(accept);
        driver.navigate().refresh();
        utils.waitClick(roninNetwork);
        utils.waitClick(saigonNetwork);
        driver.navigate().to("https://testnet.ronfi.io/");
    }
}
