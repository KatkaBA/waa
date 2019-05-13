package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClickMeBabyHomework {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        driver = new ChromeDriver();
        driver.get("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        WebElement clickMeButton = driver.findElement(By.id("clickMe"));
        for (int i = 0; i < 10; i++) {
            clickMeButton.click();
            //overit sklonovanie podla podmienky
            String actualDescription = driver.findElement(By.cssSelector("p.description")).getText();
            //i=0
            if (i == 0) {
                Assert.assertEquals("klik", actualDescription);
            }
            if (i > 0 && i < 4) {
                Assert.assertEquals("kliky", actualDescription);
            }
            if (i > 4){
                Assert.assertEquals("klikov", actualDescription);
            }
            System.out.println(actualDescription);

        }

    }

}
