package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {

    @FindBy(name = "title")
    private WebElement writeTitle;

    @FindBy(name = "author")
    private WebElement writeAuthor;

    @FindBy(name = "message")
    private WebElement writeMessage;

    private WebDriver pageDriver;

    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void enterNoteData(String title, String person, String message){
        //pageDriver.findElement(By.name("title")).sendKeys(title);
        //pageDriver.findElement(By.name("author")).sendKeys(person);
        //pageDriver.findElement(By.name("message")).sendKeys(message);
        writeTitle.sendKeys(title);
        writeAuthor.sendKeys(person);
        writeMessage.sendKeys(message);
    }

    public void submitNewNote(){
        pageDriver.findElement(By.cssSelector("button.btn-block")).click();
    }

    public WebElement getLastNoteFromList(){
        return pageDriver.findElement(By.cssSelector("ul.list-of-sins > li:last-child"));
    }

    public void checkNoteDetail(String title, String author, String message){
        WebElement detail = pageDriver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
    }

    public void checkNoteInList(String title){
        WebElement listOfItem = getLastNoteFromList();
        Assert.assertTrue(listOfItem.getText().contains(title));
        Assert.assertTrue(listOfItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listOfItem.findElement(By.cssSelector("div.description a")).getText());
    }
}
