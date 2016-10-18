package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Sergii_Chertkov on 10/18/2016.
 */
public class MainPage extends Page{
    public static String URL = "https://ru43.voyna-plemyon.ru/game.php";
    public MainPage(WebDriver driver){
        super(driver);
    }
}
