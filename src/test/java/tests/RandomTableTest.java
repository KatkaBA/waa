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

import java.util.List;

public class RandomTableTest extends TestBase {

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        driver.get(BASE_URL + "/tabulka.php");

    }


    @Test
    public void itShouldPrintLastRow() {

        //najdem a vypisem posledny riadok tabulky

        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());

        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());

        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[4]")).getText());


    }
    @Test
    public void itShouldContainDataForEachRow(){
        //List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        List<WebElement> tableRows = getRows();
        for (WebElement tableRow : tableRows) {
            //overenie, ze riadok nie je prazdny (v cykle sa vykona pre kazdy riadok tabulky)
            Assert.assertFalse(tableRow.getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainNameForEachRow(){
        //List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        List<WebElement> tableRows = getRows();
        for (WebElement tableRow : tableRows) {
            //tableRow.findElement(By.xpath("./td[2]"));
            tableRow.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());
            System.out.println(rowName.getText());

        }
    }

    private List<WebElement> getRows (){
       return driver.findElements(By.cssSelector("table tbody tr"));
    }






}
