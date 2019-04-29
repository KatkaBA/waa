package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {

        WebDriver driver;
        //typ názov;

        @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "chromedriver74");
            driver = new ChromeDriver();
            driver.get("http://localhost:8888/registracia.php");
        }

        @After
        public void tearDown() {
            //zatvorit prehliadac
            driver.close();
            //ukoncit session
            driver.quit();
        }


        @Test
        public void itShouldRegisterValidUsed(){

            String email = "jankomrkvicka2@gmail.com";
            String meno = "janko";
            String priezvisko = "mrkvicka";
            String heslo = "heslo2";
            //zadam zakaldne udaje
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("name")).sendKeys(meno);
            driver.findElement(By.name("surname")).sendKeys(priezvisko);
            driver.findElement(By.name("password")).sendKeys(heslo);
            driver.findElement(By.name("password-repeat")).sendKeys(heslo);
            //kliknem na checkbox
            driver.findElement(By.id("checkbox")).click();
            //kliknem na registruj
            driver.findElement(By.cssSelector("button.btn-success")).click();
            //overit uspesnu hlasku
            Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
            //overit, ze nie je pravda ze element je zobrazeny
            //Assert.assertFalse(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
        }


        @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty () {
            //kliknut na checkbox som robot
            driver.findElement(By.id("checkbox")).click();
            //kliknut na tlacidlo registrovat sa
            driver.findElement(By.cssSelector("button.btn-success")).click();
            //overiť uspesnu hlasku
            Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
        }
    }
