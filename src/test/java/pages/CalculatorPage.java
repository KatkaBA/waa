package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    WebDriver pageDriver;

    public CalculatorPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void enterFirstInput(){
        pageDriver.findElement(By.id("firstInput")).sendKeys("4");
    }

    public void enterSecondInput(){
        pageDriver.findElement(By.id("secondInput")).sendKeys("3");
    }

    public void sumNumbers(){
        pageDriver.findElement(By.id("count")).click();
    }

    public void deductNumbers(){
        pageDriver.findElement(By.id("deduct")).click();
    }

    public String getResults(){
        return pageDriver.findElement(By.id("result")).getText();
    }

    public void resetCalculator(){
        pageDriver.findElement(By.id("reset")).click();
    }

    public WebElement getLastCalculation(){
        return pageDriver.findElement(By.cssSelector("ul.latest-results li"));
    }

    //private List<WebElement> getLastCalculations(){
    //return driver.findElement(By.cssSelector("ul.latest-results li"));
    //}
}
