package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CalculatorTest extends TestBase {
    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        //1. otvorit stranku
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    public void enterNumbersAndClickOnSumButton (){
        enterFirstInput();
        enterSecondInput();
        sumNumbers();
        Assert.assertEquals("7", getResults());
    }

    @Test
    public void enterNumbersAndClickOnDeductButton(){
        enterFirstInput();
        enterSecondInput();
        deductNumbers();
        Assert.assertEquals("1",getResults());
    }

    @Test
    public void itShouldResetCalculator(){
        enterFirstInput();
        enterSecondInput();
        sumNumbers();
        resetCalculator();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculations(){
        enterFirstInput();
        enterSecondInput();
        sumNumbers();
        Assert.assertEquals("4 + 3 = 7", getLastCalculation().getText());
        Assert.assertEquals(1, driver.findElement(By.cssSelector("ul.latest-results li")).getText());
    }

    private void enterFirstInput(){
        driver.findElement(By.id("firstInput")).sendKeys("4");
    }

    private void enterSecondInput(){
        driver.findElement(By.id("secondInput")).sendKeys("3");
    }

    private void sumNumbers(){
        driver.findElement(By.id("count")).click();
    }

    private void deductNumbers(){
        driver.findElement(By.id("deduct")).click();
    }

    private String getResults(){
        return driver.findElement(By.id("result")).getText();
    }

    private void resetCalculator(){
        driver.findElement(By.id("reset")).click();
    }

    private WebElement getLastCalculation(){
        return driver.findElement(By.cssSelector("ul.latest-results li"));
    }

    //private List<WebElement> getLastCalculations(){
        //return driver.findElement(By.cssSelector("ul.latest-results li"));
    //}






}
