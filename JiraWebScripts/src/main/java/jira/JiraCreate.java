package jira;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class JiraCreate {
    SelenideElement issueTypeField = $(By.id("issuetype-field"));
    ElementsCollection issueTypeSuggestions = $(By.id("issuetype-suggestions")).$$(By.xpath(".//li"));
    SelenideElement summaryField = $(By.id("summary"));
    SelenideElement labelsField = $(By.id("labels-textarea"));
    SelenideElement createButton = $(By.id("create-issue-submit"));

    void createIssue(String type, String summary, String labels) {
        for (int i = 0; i < 20; i++) {
            issueTypeField.sendKeys(Keys.BACK_SPACE);
        }
        issueTypeField.clear();
        issueTypeField.sendKeys(type);
        issueTypeSuggestions.get(0).waitUntil(exist, 2000);
        issueTypeSuggestions.get(0).click();
        summaryField.sendKeys(summary);
        labelsField.sendKeys(labels);
        createButton.click();
    }
}
