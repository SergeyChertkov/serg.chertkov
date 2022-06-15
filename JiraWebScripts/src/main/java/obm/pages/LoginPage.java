package obm.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private SelenideElement userNameField = $$(By.name("username")).get(1);
    private SelenideElement passwordField = $$(By.name("username")).get(1);
    private SelenideElement loginButton = $(By.xpath("//button//*[@*='login.form.button']"));

    public DistributionsPage login(String userName, String password) {
        userNameField.waitUntil(exist, 10000);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DistributionsPage();
    }
}
