package io.ronfi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//div[@class='base__Box-sc-18gtznx-1 hfhsDi']//button[@class='Buttons__Button-sc-1jc3gkb-0 dSLUnp'][normalize-space()='Connect Wallet']")
    public WebElement connectWallet;
    @FindBy(xpath = "//div[@class='base__Box-sc-18gtznx-1 base__Flex-sc-18gtznx-2 bOpaAK bjlZRc']")
    public WebElement btnUserAccount;
    @FindBy(xpath = "//a[text() = 'Stake RON']")
    public WebElement switchToScreenStake;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
