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

import java.sql.SQLOutput;
import java.sql.Timestamp;

public class OdkazovacTest extends TestBase {

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        //1. otvorit stranku
        driver.get(BASE_URL + "/odkazovac.php");

    }

    @Test
    public void itShouldAddNote() throws InterruptedException {

        String title = "Ahoj";
        String author = "Jano";
        String message = "Mas sa dobre";

        Integer numberOfNotes = Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText());
        //driver.findElement(By.name("title")).sendKeys(title); //vlozit slovo
        //driver.findElement(By.name("author")).sendKeys(author);
        //driver.findElement(By.name("message")).sendKeys(message);
        enterNoteData(title,author,message);
        //driver.findElement(By.cssSelector("button.btn-block")).click();
        submitNewNote();
        checkNoteInList(title);
        getLastNoteFromList().click();

        //WebElement listOfItem = getLastNoteFromList();
        //overim, ze sa pridal novy zaznam do zoznamu

        //Assert.assertTrue(listOfItem.getText().contains(title));
        //overenie linku
        //Assert.assertTrue(listOfItem.findElement(By.cssSelector("div.description a")).isDisplayed());

        //Assert.assertEquals(
                //Integer.valueOf(numberOfNotes + 1),
                //Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText()));

        //listOfItem.click();
        //overim detail zaznamu
        Thread.sleep(1000);
        checkNoteDetail(title, author, message);
        //WebElement detail = driver.findElement(By.cssSelector("div.content"));
        //Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        //Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        //Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
    }

    @Test
    public void itShouldAddNoteWithTimestamp(){
        //vytvorenie casovej peciatky,  vsetko za "new" je konstruktor
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String title = "ahoj" + timestamp.getTime();
        String author = "Jano";
        String message = "mas sa";

        //driver.findElement(By.name("title")).sendKeys(title); //vlozit slovo
        //driver.findElement(By.name("author")).sendKeys(author);
        //driver.findElement(By.name("message")).sendKeys(message);
        enterNoteData(title,author,message);

        driver.findElement(By.cssSelector("button.btn-block")).click();
        Assert.assertTrue(driver.findElement(By.id("1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a")).isDisplayed());

    }

    @Test
    public void itShoulAddNoteWithHashtags() throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String title = "Ahoj" + timestamp.getTime();
        String author = "Jano";
        String message = "Mas sa ?";

        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(author);
        driver.findElement(By.name("message")).sendKeys(message);

        driver.findElement(By.cssSelector(".checkbox-inline input[value='sport']")).click();
        driver.findElement(By.cssSelector(".checkbox-inline input[value='moda']")).click();

        Integer numberOfNotes = Integer.valueOf(driver.findElement(By.cssSelector("h3 span")).getText());
        driver.findElement(By.cssSelector("form button.btn.btn-block")).click();
        Integer newNumberOfNotes = Integer.valueOf(driver.findElement(By.cssSelector("h3 span")).getText());

        Assert.assertEquals(Integer.valueOf(numberOfNotes + 1), newNumberOfNotes);
        System.out.println(newNumberOfNotes);

        WebElement detailLink = driver.findElement(By.cssSelector("ul.list-of-sins >  li:last-child a"));
        Assert.assertTrue(detailLink.isDisplayed());
        detailLink.click();
        Thread.sleep(1000);

        WebElement detail = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
        Assert.assertEquals("#sport", detail.findElement(By.cssSelector("li:first-child")).getText());
        Assert.assertEquals("#moda", detail.findElement(By.cssSelector("li:last-child")).getText());

    }
    private void enterNoteData(String title, String person, String message){
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(person);
        driver.findElement(By.name("message")).sendKeys(message);
    }

    private void submitNewNote(){
        driver.findElement(By.cssSelector("button.btn-block")).click();
    }

    private WebElement getLastNoteFromList(){
        return driver.findElement(By.cssSelector("ul.list-of-sins > li:last-child"));
    }

    private void checkNoteDetail(String title, String author, String message){
        WebElement detail = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
    }

    private void checkNoteInList(String title){
        WebElement listOfItem = getLastNoteFromList();
        Assert.assertTrue(listOfItem.getText().contains(title));
        Assert.assertTrue(listOfItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listOfItem.findElement(By.cssSelector("div.description a")).getText());
    }



}
