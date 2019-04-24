package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {


    @Test
    public void itShouldAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver(); //chcem vytvorit novy objekt vo webdriveri, ktory sme si nazvali driver, ktory bude nova instancia ChromeDiver
        //1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        //2. kliknut na button pridat
        driver.findElement(By.id("addRyan")).click();
        //odobrat ryana
        //driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        //skratka sout - vypise do spodnej konzoli aktualny stav pocitadla
        //lokator je cele od By. ....
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();

        Assert.assertEquals("3", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());


        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();


    }

    @Test
    public void itShouldDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver(); //chcem vytvorit novy objekt vo webdriveri, ktory sme si nazvali driver, ktory bude nova instancia ChromeDiver
        //1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");


        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

        //COMD+D duplikuje riadok


        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver(); //chcem vytvorit novy objekt vo webdriveri, ktory sme si nazvali driver, ktory bude nova instancia ChromeDiver
        //1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");


        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();



        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );

        //COMD+D duplikuje riadok


        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }
}
