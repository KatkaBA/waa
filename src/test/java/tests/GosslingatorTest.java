package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    WebDriver driver;

    String actualNumberOfRyans;
    String actualRyanDescription;

    @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        //0. spustit prehliadac
        driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");


    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }



    @Test
    public void itShouldAddOneRyan() {

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        //2. kliknut na button pridat
        addRyanButton.click();
        //odobrat ryana
        //driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        actualNumberOfRyans = driver.findElement(By.cssSelector("div.ryan-counter h2")).getText();
        actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
        Assert.assertEquals("1",actualNumberOfRyans);
        //skratka sout - vypise do spodnej konzoli aktualny stav pocitadla
        //lokator je cele od By. ....
        System.out.println("Number of ryans: " + actualNumberOfRyans);
        Assert.assertEquals("ryan", actualRyanDescription);
        addRyanButton.click();
        addRyanButton.click();
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
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnavam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na string aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            //overit sklonovanie podla podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            //i=0
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
            //odtestovat pocat zobrazenych ryanov
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
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
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clickslimit = 30;
        int clicks = 0;

        //while cyklus sa vykona vzdy ak je podmienka "true"
        while (!actualNumberOfRyans.equals("50") && clicks < clickslimit) {
            //!= negacia hodnoty
            addRyanButton.click();
            //vzdy po kliknuti musim vytiahnut zo stranky aktualnu hodnotu a porovnat ju
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //addRyan a ActualNumber nemoze byt naopak, lebo sa priradi hodnota (zisti 50) ale este stihne kliknut
            clicks++;
        }
    }
    @Test
    public void itShouldDisplayNoRyanOnPageOpen (){
        Assert.assertEquals(0, driver.findElements(By.cssSelector("img")).size());
    }
}
