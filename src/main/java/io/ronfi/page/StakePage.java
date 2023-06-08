package io.ronfi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StakePage {
    @FindBy(xpath = "//button[normalize-space()='Stake']")
    public WebElement btnStake;
    @FindBy(xpath = "//input[@placeholder='0.00']")
    public WebElement inputToken;

    public StakePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
