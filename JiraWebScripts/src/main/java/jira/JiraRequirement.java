package jira;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class JiraRequirement {
    SelenideElement linkTestCase = $(By.id("req-tc-link-tc"));
    SelenideElement field = $(By.id("jira-issue-picker-keys-textarea"));
    SelenideElement link = $(By.id("issue-link"));

    public void linkTestCase(String id) {
        linkTestCase.click();
        field.waitUntil(Condition.exist, 5000);
        field.sendKeys(id);
        field.sendKeys(Keys.ENTER);
        link.click();
    }
}
