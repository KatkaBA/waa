package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {


  @Test
  public void itShouldAddOneRyan(){
    System.setProperty("webdriver.chrome.driver","chromedriver");
      //0. spustit prehliadac
    WebDriver driver = new ChromeDriver(); //chcem vytvorit novy objekt vo webdriveri, ktory sme si nazvali driver, ktory bude nova instancia ChromeDiver
     //1. otvorit stranku
    driver.get("http://localhost:8888/gosslingator.php");
     //2. kliknut na button pridat
    driver.findElement(By.id("addRyan")).click();
    //odobrat ryana
    driver.findElement(By.id("removeRyan")).click();
      // 3. overit pocitanie ryanov
    Assert.assertEquals("0", driver.findElement(By.id("ryanCounter")).getText());
    //zatvorit prehliadac
    driver.close();
    //ukoncit session
    driver.quit();



  }

}
