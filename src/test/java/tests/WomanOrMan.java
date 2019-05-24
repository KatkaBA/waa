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

public class WomanOrMan extends TestBase {
    WebElement conchita;
    WebElement wurst;
    WebElement checkText;
    boolean conchitaIsSelected;
    boolean wurstIsSelected;


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/zenaalebomuz.php");
    }


    @Test
    public void noOptionShouldBeSelected (){
        conchita = driver.findElement(By.cssSelector("input[value='conchita']"));
        wurst = driver.findElement(By.cssSelector("input[value='wurst']"));
        conchitaIsSelected = conchita.isSelected();
        wurstIsSelected = wurst.isSelected();

        Assert.assertFalse(conchitaIsSelected);
        Assert.assertFalse(wurstIsSelected);

        checkText = driver.findElement(By.cssSelector("h1.description"));
        wurst.click();
        Assert.assertEquals("It's wurst", checkText.getText());
        conchita.click();
        Assert.assertEquals("It's conchita", checkText.getText());
    }

    @Test
    public void itShouldCheckTheRadioButtonIsNotClicked(){
        conchita = driver.findElement(By.cssSelector("input[value='conchita']"));
        wurst = driver.findElement(By.cssSelector("input[value='wurst']"));
        wurst.click();
        conchitaIsSelected = conchita.isSelected();
        wurstIsSelected = wurst.isSelected();

        Assert.assertFalse(conchitaIsSelected);
        Assert.assertTrue(wurstIsSelected);
    }

    @Test
    public  void itShouldCheckImageIsVisible(){
        driver.findElement(By.cssSelector("img")).isDisplayed();
    }
}
