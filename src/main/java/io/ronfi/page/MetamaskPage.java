package io.ronfi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetamaskPage {
    @FindBy(xpath = "//div[text() = 'Confirm']")
     public WebElement confirm;
    @FindBy(xpath = "//div[text() = 'Cancel']")
    public WebElement cancel;

    public MetamaskPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
