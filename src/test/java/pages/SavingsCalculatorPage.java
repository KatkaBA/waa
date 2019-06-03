package pages;

import io.codearte.jfairy.Fairy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorPage {
    WebDriver pageDriver;

    private Fairy fairy;

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

    public void fillInputs(){
        selectFund("Handelsbanken Aktiv 100");
        addInvestment("50");
        addPeriod("3");
        fairy = Fairy.create();
        addEmail(fairy.person().getEmail());
    }

}
