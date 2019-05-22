package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathHomework extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }

    @Test
    public void itShouldClickOnAllButtonsAndCheckMessage () {
        String [] buttons = {"First one", "Second button", "Next button", "One more button", "Danger", "Success", "Warning"};
        for (String button : buttons){
            String xpath = "//button[contains(text(),'" + button + "')]";
            driver.findElement(By.xpath(xpath)).click();
            Assert.assertEquals("you clicked " + button.toLowerCase(), driver.findElement(By.cssSelector("div.output h2 span")).getText());
            System.out.println(xpath);
        }
    }

    @Test
    public void isShouldSelectNumberOneAndCheckMessage (){
        WebElement moznostWebElement = driver.findElements(By.cssSelector("div.useless-number-two select")).get(0);
        for (int i=1; i<7; i++){
            Select select = new Select(moznostWebElement);
            select.selectByIndex(i);
            String selectedText = select.getFirstSelectedOption().getText().toLowerCase();
            Assert.assertEquals("you have chosen " + selectedText, driver.findElement(By.cssSelector("div.output h2 span")).getText());
            System.out.println(selectedText);

        }

    }

    @Test
    public void isShouldSelectNumberTwoAndCheckMessage (){
        WebElement optionWebElement = driver.findElements(By.cssSelector("div.useless-number-two select")).get(1);
        for (int i=1; i<7; i++){
            Select select = new Select(optionWebElement);
            select.selectByIndex(i);
            String selectedText = select.getFirstSelectedOption().getText().toLowerCase();
            Assert.assertEquals("you have chosen " + selectedText, driver.findElement(By.cssSelector("div.output h2 span")).getText());
            System.out.println(selectedText);

        }

    }
}
