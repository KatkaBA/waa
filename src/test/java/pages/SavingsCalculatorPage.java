package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorPage {
    WebDriver pageDriver;

    @FindBy(id = "fundSelect")
    private WebElement fundSelect;

    @FindBy(id = "oneTimeInvestmentInput")
    private WebElement investmentInput;

    @FindBy(id = "yearsInput")
    private WebElement periodInput;

    @FindBy(id = "emailInput")
    private WebElement emailInput;

    @FindBy(css = "button.btn-block")
    private WebElement applyButton;

    public SavingsCalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void addInvestment(String investment){
        investmentInput.sendKeys(investment);
    }

    public void addPeriod(String period) {
        periodInput.sendKeys(period);
    }

    public void addEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectFund(String fund) {
        new Select(fundSelect).selectByVisibleText(fund);
    }

    public WebElement getApplyButton(){
        return this.applyButton;
    }

    public void clickApplyButton() {
        applyButton.click();
    }

}
