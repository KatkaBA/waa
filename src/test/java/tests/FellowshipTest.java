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

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest extends TestBase {


    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {

        driver.get(BASE_URL + "/fellowship.php");
    }


    @Test
    public void itShouldContainNameForEachFellow(){
        List<WebElement> fellowElements = getFellowElements();
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());

        }

    }

    @Test
    public void itShouldContainSpecifiedFellows(){
        //najdem si zoznam elementov (kachliciek)
        List<WebElement> fellowElements = getFellowElements();
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

    @Test
    public void itShouldCheckCompleteFellowship(){
        String pointsLeft = driver.findElement(By.cssSelector("div.points-left h2")).getText();
        Assert.assertEquals("25", pointsLeft);
        System.out.println(pointsLeft);

        driver.findElement(By.xpath("//h1[contains(text(),'Gandalf')]")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Aragorn')]")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Legolas')]")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Frodo')]")).click();
        String fellowship = driver.findElement(By.cssSelector("div.points-left h3")).getText();
        Assert.assertEquals("Complete", fellowship);
        System.out.println(fellowship);

    }

    @Test
    public void itShouldCheckPointsOfEachFellow() {
        List<WebElement> fellowElements = getFellowElements();
        List<String> fellowPoints = new ArrayList<String>();

        for (WebElement fellowElement : fellowElements) {
            fellowPoints.add(fellowElement.findElement(By.cssSelector("div.fellow-points h2")).getText());
        }
        System.out.println(fellowPoints);
        //Assert.assertEquals(9, driver.findElements(By.cssSelector("div.fellow-points h2")).size());
        Assert.assertEquals(9, driver.findElements(By.xpath("//div[contains(@class, 'fellow-points')]/h2[text()]")).size());
    }

    @Test
    public void itShouldDisplayCompleteMessage(){
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            selectFellow(fellowToSelect);

        }
        Assert.assertEquals("Complete", driver.findElement(By.cssSelector("div.points-left h3")).getText());


    }
    @Test
    public void itShouldDisplayPointsForEachFellow() {
        //najdem si zoznam vsetkych spolocnikov z ringu a ulozim ich do listu webelementov
        List<WebElement> displayedFellows = getFellowElements();
        for (WebElement displayedFellow : displayedFellows) {

            // /pre kazdeho najdem element v ktorom je ulozeny pocet bodov a zistim jeho text
            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();

            //overim ze hodnota actual points nie je prazdna
            Assert.assertFalse(actualPoints.isEmpty());
        }
    }


    private void selectFellow(String fellowName) {
        driver.findElement(By.xpath("//h1[contains(text(),'" + fellowName + "')]")).click();
    }

    private List<WebElement> getFellowElements() {
        return driver.findElements(By.cssSelector("ul.list-of-fellows li"));
    }


}
