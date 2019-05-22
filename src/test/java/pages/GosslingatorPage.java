package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GosslingatorPage {
    WebDriver pageDriver;

    public GosslingatorPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void addRyan(){
        WebElement addRyanButton = pageDriver.findElement(By.id("addRyan"));
        addRyanButton.click();
    }
    public String getRyanCounterNumber(){
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription(){
        return pageDriver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

   public int getNumberOfImages(){
        return pageDriver.findElements(By.cssSelector("img")).size();
    }
}
