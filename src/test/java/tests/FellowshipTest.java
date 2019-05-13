package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest {
    WebDriver driver;

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        //0. spustit prehliadac
        driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:8888/fellowship.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }
    @Test
    public void itShouldContainNameForEachFellow(){
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());

        }

    }

    @Test
    public void itShouldContainSpecifiedFellows(){
        //najdem si zoznam elementov (kachliciek)
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        //prepdripravim si zoznam stringov, do ktoreho si ulozim jednotlive mena
        List<String> fellowNames = new ArrayList<String>();

        //prejdem zoznam elementov (kachliciek)
        for (WebElement fellowElement : fellowElements) {
            // v ramci kazdej kachlicky si najdem meno a ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));

    }

}
