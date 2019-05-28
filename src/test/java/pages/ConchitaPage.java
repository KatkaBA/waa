package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConchitaPage {
    private WebDriver pageDriver;

    public ConchitaPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public boolean checkTheMan(){
        return pageDriver.findElement(By.xpath("//input[@value='wurst']")).isSelected();
    }

    public boolean checkTheWoman(){
        return pageDriver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected();
    }

    public void chooseMan(){
        pageDriver.findElement(By.xpath("//input[@value='wurst']")).click();
    }


}
