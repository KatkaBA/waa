package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {

    private SavingsCalculatorPage  savingsCalculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
    }

    @Test
    public void itShouldEnableButton () {
        savingsCalculatorPage.fillInputs();

        Assert.assertTrue(savingsCalculatorPage.getApplyButton().isDisplayed());
    }

    @Test
    public void itShouldVerifyIncomes () {
        savingsCalculatorPage.fillInputs();

        WebElement totalIncome = driver.findElement(By.cssSelector("div.result div:first-child p"));
        WebElement interestIncome = driver.findElement(By.cssSelector("div.result div:nth-child(1) p"));
        Assert.assertFalse(totalIncome.getText().isEmpty());
        Assert.assertFalse(interestIncome.getText().isEmpty());
    }

    @Test
    public void itShouldVerifyRisk () {
        savingsCalculatorPage.fillInputs();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result div:last-child p")).getText().isEmpty());
    }

    @Test
    public void itShouldApplyForSaving(){
        savingsCalculatorPage.fillInputs();
        savingsCalculatorPage.clickApplyButton();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.saving-detail")).isDisplayed());
        Assert.assertEquals("Handelsbanken Aktiv 100", driver.findElement(By.cssSelector("p.fund-description")).getText());
    }

}
