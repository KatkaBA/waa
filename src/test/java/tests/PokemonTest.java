package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.print.DocFlavor;

public class PokemonTest extends TestBase {


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
    }


    @Test
    public void isShouldSelectPokemons(){
        String [] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander"};
        //najdem element select
        //WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            selectPokemon(pokemon);
            //overim hlasku
            //String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            //getActualMessage();
            //String  expectedMessage = "I choose you " + pokemon + " !";
            Assert.assertEquals(getExpectedMessage(pokemon), getActualMessage());
        }

    }
    private void selectPokemon(String pokemonToSelect){
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    private String getActualMessage(){
        return driver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    private String getExpectedMessage(String pokemonName){
        return String.format("I choose you %s !", pokemonName);
    }

}