package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConchitaTest extends TestBase {

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/zenaalebomuz.php");
    }

    @Test
    public void noOptionShouldBeSelected() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test
    public void itShouldSelectMale() {
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //overit ze moznost zena nie je vybrata
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }
}
