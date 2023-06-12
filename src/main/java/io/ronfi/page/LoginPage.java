package io.ronfi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "(//button[contains(text(), 'Connect Wallet')])[2]")
    public WebElement connectWallet;
    @FindBy(xpath = "(//div[contains(text(), 'ronin:4E4...e9e')])[2]")
    public WebElement btnUserAccount;
    @FindBy(xpath = "//a[text() = 'Stake RON']")
    public WebElement switchToScreenStake;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
