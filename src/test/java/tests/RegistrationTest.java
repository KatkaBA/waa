package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest extends TestBase {


        @Before //anotacia, ze tuto cast chcem otvorit vzdy pred testom
        public void openPage() {

            driver.get(BASE_URL + "/registracia.php");
        }

        @Test
        public void itShouldRegisterValidUsed(){
            Person person = Fairy.create().person();

            //zadam zakaldne udaje
            driver.findElement(By.name("email")).sendKeys(person.getEmail());
            driver.findElement(By.name("name")).sendKeys(person.getFirstName());
            driver.findElement(By.name("surname")).sendKeys(person.getLastName());
            driver.findElement(By.name("password")).sendKeys(person.getPassword());
            driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
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
