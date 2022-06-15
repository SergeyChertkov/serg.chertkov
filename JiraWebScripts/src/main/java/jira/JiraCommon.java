package jira;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JiraCommon {
    SelenideElement createButton = $(By.id("create_link"));

    SelenideElement issuesMenu = $(By.id("find_link"));
    ElementsCollection recentIssues = $(By.id("issues_history_main")).$$(By.xpath(".//a"));

}
