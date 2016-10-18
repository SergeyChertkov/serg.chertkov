package pages;

import main.Element;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sergii_Chertkov on 10/18/2016.
 */
public class LoginPage extends Page{
    public String URL = "https://www.voyna-plemyon.ru/";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public Page login(String user, String password){
        byXpath(Element.login).sendKeys(user);
        byXpath(Element.password).sendKeys(password);
        byXpath(Element.loginButton).click();
        pause(2);
        byXpath(Element.selectWorld).click();
        pause(2);
        return new MainPage(driver);
    }
}
