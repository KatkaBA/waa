package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class CalculatorTest extends TestBase {
    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        //1. otvorit stranku
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    public void enterNumbersAndClickOnSumButton (){
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("7", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void enterNumbersAndClickOnDeductButton(){
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("1",driver.findElement(By.id("result")).getText());
    }

    @Test
    public void itShouldResetCalculator(){
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculations(){
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("4 + 3 = 7", driver.findElement(By.cssSelector("ul.latest-results li")).getText());
        Assert.assertEquals(1, driver.findElement(By.cssSelector("ul.latest-results li")).getText());
    }


}
