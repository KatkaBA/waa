package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {

    private SavingsCalculatorPage  savingsCalculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
    }

    @Test
    public void itShouldEnableButton() {
        savingsCalculatorPage.fillInputs();

        Assert.assertTrue(savingsCalculatorPage.getApplyButton().isDisplayed());
    }

    @Test
    public void itShouldVerifyIncomes() {
        savingsCalculatorPage.fillInputs();

        Assert.assertFalse(savingsCalculatorPage.getTotalIncome().getText().isEmpty());
        Assert.assertFalse(savingsCalculatorPage.getInterestIncome().getText().isEmpty());
    }

    @Test
    public void itShouldVerifyRisk() {
        savingsCalculatorPage.fillInputs();
        Assert.assertFalse(savingsCalculatorPage.getRisk().getText().isEmpty());
    }

    @Test
    public void itShouldApplyForSaving(){
        savingsCalculatorPage.fillInputs();
        savingsCalculatorPage.clickApplyButton();

        Assert.assertTrue(savingsCalculatorPage.getSavingDetail().isDisplayed());
        Assert.assertEquals("Handelsbanken Aktiv 100", savingsCalculatorPage.getFundDescription());
        Assert.assertTrue(savingsCalculatorPage.getSavingDetailAmounts().isDisplayed());
    }

}
