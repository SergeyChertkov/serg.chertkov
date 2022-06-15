package jira;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

class JiraTestCase {
    SelenideElement step = $(By.id("ta-tsStep"));
    SelenideElement stepData = $(By.id("ta-tsStepData"));
    SelenideElement stepExpectedResult = $(By.id("ta-tsExpectedResult"));
    SelenideElement addStepButton = $(By.id("tsAdd"));
    SelenideElement id = $(By.id("key-val"));

    void addStep(List<String> data){
        step.sendKeys(data.get(0));
        stepData.sendKeys(data.get(1));
        stepExpectedResult.sendKeys(data.get(2));
        addStepButton.click();
    }
}
