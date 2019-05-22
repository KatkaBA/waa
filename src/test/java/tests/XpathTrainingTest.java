package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTest extends TestBase {

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {

        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }


    @Test
    public void itShouldDisplayAction() {

        //2.najst button
        driver.findElement(By.xpath("//button[contains(text(),'Second button')]")).click();
        //3.overit text po kliknuti na button
        //najprv musim kliknut na tlacidlo, az potom vlozit string
        String checkText = driver.findElement(By.xpath("//div[contains(@class, 'output')]/h2/span")).getText();

        Assert.assertEquals("you clicked second button", checkText);
        //4. vypisat text do vysledku testu
        System.out.println(checkText);
    }



    @Test
    public  void itShouldDisplayEnteredMessage() {
        String message = "prsi";
                //string= retazec znakov

        //najst element, v ktorom je vpisany text
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        //stlacim tlacidlo hit me
        driver.findElement(By.id("hitme")).click();
        //overim hlasku

        //precitam hodnotu zo stranky a ulozim ju do premennej
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals("you entered " + message, actualMessage);

    }
 //DRY = don't repeat yourself


}
