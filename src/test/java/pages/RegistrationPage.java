package pages;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver pagedriver;

    public RegistrationPage(WebDriver driver){
        this.pagedriver = driver;
    }

    public void clickOnCheckboxAndRegistration(){
        pagedriver.findElement(By.id("checkbox")).click();
        pagedriver.findElement(By.cssSelector("button.btn-success")).click();
    }

    public void fillOutValidUser(){
        Person person = Fairy.create().person();
        pagedriver.findElement(By.name("email")).sendKeys(person.getEmail());
        pagedriver.findElement(By.name("name")).sendKeys(person.getFirstName());
        pagedriver.findElement(By.name("surname")).sendKeys(person.getLastName());
        pagedriver.findElement(By.name("password")).sendKeys(person.getPassword());
        pagedriver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
    }

    public void checkIfSuccessMessageIsDisplayed(){
        Assert.assertTrue(pagedriver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
    }

    public void checkIfDangerMessageIsDisplaved (){
        Assert.assertTrue(pagedriver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}
