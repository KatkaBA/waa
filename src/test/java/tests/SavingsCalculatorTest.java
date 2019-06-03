package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {

    private SavingsCalculatorPage  savingsCalculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
    }

    @Test
    public void itShouldEnableButton (){
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        new Select(fundSelect).selectByVisibleText("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isDisplayed());
    }

    @Test
    public void itShouldVerifyIncomes () {
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        new Select(fundSelect).selectByVisibleText("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result div:first-child p")).getText().isEmpty());
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result div:nth-child(1) p")).getText().isEmpty());
    }

    @Test
    public void itShouldVerifyRisk () {
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        new Select(fundSelect).selectByVisibleText("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result div:last-child p")).getText().isEmpty());
    }

    @Test
    public void itShouldApplyForSaving(){
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        new Select(fundSelect).selectByVisibleText("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");
        driver.findElement(By.cssSelector("button.btn-block")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.saving-detail")).isDisplayed());
        Assert.assertEquals("Handelsbanken Aktiv 100", driver.findElement(By.cssSelector("p.fund-description")).getText());
    }








}
