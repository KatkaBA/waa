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

    private String [] selectedFunds = {"Handelsbanken Aktiv 100", "Hoggwart's Fund",
            "Fellowship investment group", "McDuck's safe", "Batman's Cave Development",
            "Death Star real estate", "Tom & Jerry corp"};

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
    }

    @Test
    public void itShouldEnableButton () {
        savingsCalculatorPage.selectFund("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");

        Assert.assertTrue(savingsCalculatorPage.getApplyButton().isDisplayed());
    }

    @Test
    public void itShouldVerifyIncomes () {
        savingsCalculatorPage.selectFund("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");

        WebElement totalIncome = driver.findElement(By.cssSelector("div.result div:first-child p"));
        WebElement interestIncome = driver.findElement(By.cssSelector("div.result div:nth-child(1) p"));
        Assert.assertFalse(totalIncome.getText().isEmpty());
        Assert.assertFalse(interestIncome.getText().isEmpty());
    }

    @Test
    public void itShouldVerifyRisk () {
        savingsCalculatorPage.selectFund("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");

        Assert.assertFalse(driver.findElement(By.cssSelector("div.result div:last-child p")).getText().isEmpty());
    }

    @Test
    public void itShouldApplyForSaving(){
        savingsCalculatorPage.selectFund("Handelsbanken Aktiv 100");
        savingsCalculatorPage.addInvestment("50");
        savingsCalculatorPage.addPeriod("3");
        savingsCalculatorPage.addEmail("vymyslena@test.sk");
        savingsCalculatorPage.clickApplyButton();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.saving-detail")).isDisplayed());
        Assert.assertEquals("Handelsbanken Aktiv 100", driver.findElement(By.cssSelector("p.fund-description")).getText());
    }








}
