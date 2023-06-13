package io.ronfi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StakePage {

    @FindBy(xpath = "//div[@class='base__Box-sc-18gtznx-1 dGiMQM']")
    public WebElement allPage;
    @FindBy(xpath = "//button[normalize-space()='Stake']")
    public WebElement btnStake;
    @FindBy(xpath = "//input[@placeholder='0.00']")
    public WebElement inputToken;
    @FindBy(xpath = "//div[contains(text(), 'Minimum amount is 0.01 RON')]")
    public WebElement messageInputToken;
    @FindBy(xpath = "//span[@class=\"base__Box-sc-18gtznx-1 kUsDBq\"]")
    public WebElement numberToken;


    public StakePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
