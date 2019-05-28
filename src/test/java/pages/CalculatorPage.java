package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalculatorPage {
    WebDriver pageDriver;

    @FindBy(id = "firstInput")
    private WebElement firstInput;

    @FindBy(id = "secondInput")
    private WebElement secondInput;

    @FindBy(id = "count")
    private WebElement countButton;

    @FindBy(id = "deduct")
    private WebElement deductButton;

    @FindBy(id = "result")
    private WebElement result;

    @FindBy(id = "reset")
    private WebElement resetButton;


    public CalculatorPage(WebDriver driver){
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void enterFirstInput(){
        firstInput.sendKeys("4");
}

    public void enterSecondInput(){
        secondInput.sendKeys("3");
    }

    public void sumNumbers(){
        countButton.click();
    }

    public void deductNumbers(){
        deductButton.click();
    }

    public String getResults(){
        return result.getText();
    }

    public void resetCalculator(){
        resetButton.click();
    }

    public WebElement getLastCalculation(){
        return pageDriver.findElement(By.cssSelector("ul.latest-results li"));
    }

    public List<WebElement> getLastCalculations() {
        return pageDriver.findElements(By.cssSelector("ul.latest-results li"));
    }

    public WebElement getFirstInput(){
        return firstInput;
    }

    public WebElement getSecondInput(){
        return secondInput;
    }

}
