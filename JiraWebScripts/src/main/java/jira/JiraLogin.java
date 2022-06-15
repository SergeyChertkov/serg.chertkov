package jira;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class JiraLogin {
    private SelenideElement userNameField = $(By.id("login-form-username"));
    private SelenideElement passwordField = $(By.id("login-form-password"));
    private SelenideElement loginButton = $(By.id("login"));

    void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
