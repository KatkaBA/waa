package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConchitaPage;

public class ConchitaTest extends TestBase {
    private ConchitaPage conchitaPage;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/zenaalebomuz.php");
        conchitaPage = new ConchitaPage(driver);
    }

    @Test
    public void noOptionShouldBeSelected() {
        //Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(conchitaPage.checkTheMan());
        //Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
        Assert.assertFalse(conchitaPage.checkTheWoman());
    }

    @Test
    public void itShouldSelectMale() {
        //driver.findElement(By.xpath("//input[@value='wurst']")).click();
        conchitaPage.chooseMan();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //overit ze moznost zena nie je vybrata
        //Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
        Assert.assertFalse(conchitaPage.checkTheWoman());
    }


}
