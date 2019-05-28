package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;

import java.util.List;


public class CalculatorTest extends TestBase {
    private CalculatorPage calculatorPage;

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        //1. otvorit stranku
        driver.get(BASE_URL + "/kalkulacka.php");
        calculatorPage = new CalculatorPage(driver);
    }

    @Test
    public void enterNumbersAndClickOnSumButton (){
        calculatorPage.enterFirstInput();
        calculatorPage.enterSecondInput();
        calculatorPage.sumNumbers();
        Assert.assertEquals("7", calculatorPage.getResults());
    }

    @Test
    public void enterNumbersAndClickOnDeductButton(){
        calculatorPage.enterFirstInput();
        calculatorPage.enterSecondInput();
        calculatorPage.deductNumbers();
        Assert.assertEquals("1",calculatorPage.getResults());
    }

    @Test
    public void itShouldResetCalculator(){
        calculatorPage.enterFirstInput();
        calculatorPage.enterSecondInput();
        calculatorPage.sumNumbers();
        calculatorPage.resetCalculator();
        Assert.assertTrue(calculatorPage.getFirstInput().getAttribute("value").isEmpty());
        Assert.assertTrue(calculatorPage.getSecondInput().getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculations(){
        calculatorPage.enterFirstInput();
        calculatorPage.enterSecondInput();
        calculatorPage.sumNumbers();
        Assert.assertEquals("4 + 3 = 7", calculatorPage.getLastCalculation().getText());
        Assert.assertEquals(1, driver.findElement(By.cssSelector("ul.latest-results li")).getText());
    }

    //private List<WebElement> getLastCalculations(){
        //return driver.findElement(By.cssSelector("ul.latest-results li"));
    //}


}
