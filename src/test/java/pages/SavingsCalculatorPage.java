package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SavingsCalculatorPage {


    WebDriver pageDriver;
    public SavingsCalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }


    public void addInvestment(String investment){
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investment);
    }

    public void addPeriod(String period) {
        pageDriver.findElement(By.id("yearsInput")).sendKeys(period);
    }

    public void addEmail(String email) {
        pageDriver.findElement(By.id("emailInput")).sendKeys(email);}
}
