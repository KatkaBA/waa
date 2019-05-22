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

public class GosslingatorTest extends TestBase {

    private String actualNumberOfRyans;
    private String actualRyanDescription;

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void openPage() {
        //1. otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");

    }


    @Test
    public void itShouldAddOneRyan() {

        addRyan();
        //odobrat ryana
        //driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        //actualNumberOfRyans = driver.findElement(By.cssSelector("div.ryan-counter h2")).getText();
        actualNumberOfRyans = getRyanCounterNumber();
        actualRyanDescription = getCounterDescription();
        Assert.assertEquals("1",actualNumberOfRyans);
        //skratka sout - vypise do spodnej konzoli aktualny stav pocitadla
        //lokator je cele od By. ....
        System.out.println("Number of ryans: " + actualNumberOfRyans);
        Assert.assertEquals("ryan", actualRyanDescription);
        addRyan();
        addRyan();
        Assert.assertEquals("1", actualNumberOfRyans);
        Assert.assertEquals("ryan", actualRyanDescription);
    }

    @Test
    public void itShouldDisplayTitle() {

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

        //COMD+D duplikuje riadok
    }


    @Test
    public void itShouldDisplayWarningMessage() {

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        //WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyan();
            String actualNumberOfRyans = getRyanCounterNumber();
            //porovnavam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na string aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            //overit sklonovanie podla podmienky
            String actualDescription = getCounterDescription();
            //i=0
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
            //odtestovat pocat zobrazenych ryanov
            int numberOfRyanImages = getNumberOfImages();
            Assert.assertEquals(i + 1, numberOfRyanImages);


            System.out.println("index i = + 1");
            System.out.println("pocet ryanov = " + actualNumberOfRyans);

        }
        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );


        //COMD+D duplikuje riadok


    }
    @Test
    public  void  isShouldDisplayWarningMassageWhileCycle (){
        //WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        //String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clickslimit = 30;
        int clicks = 0;

        //while cyklus sa vykona vzdy ak je podmienka "true"
        while (!getRyanCounterNumber().equals("50") && clicks < clickslimit) {
            //!= negacia hodnoty
            addRyan();
            //vzdy po kliknuti musim vytiahnut zo stranky aktualnu hodnotu a porovnat ju
            getRyanCounterNumber();
            //addRyan a ActualNumber nemoze byt naopak, lebo sa priradi hodnota (zisti 50) ale este stihne kliknut
            clicks++;
        }
    }
    @Test
    public void itShouldDisplayNoRyanOnPageOpen (){
        Assert.assertEquals(0, getNumberOfImages());
    }

    private void addRyan(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
    }

    private String getRyanCounterNumber(){
        return driver.findElement(By.id("ryanCounter")).getText();
    }

    private String getCounterDescription(){
        return driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    private int getNumberOfImages(){
        return driver.findElements(By.cssSelector("img")).size();
    }

}
