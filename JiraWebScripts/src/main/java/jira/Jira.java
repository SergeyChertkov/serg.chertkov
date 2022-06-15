package jira;

import com.codeborne.selenide.Configuration;
import jira.data.TestCase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

class Jira {
    JiraCommon common = new JiraCommon();
    JiraLogin login = new JiraLogin();
    JiraCreate createPopup = new JiraCreate();
    JiraTestCase testCase = new JiraTestCase();
    JiraRequirement requirement = new JiraRequirement();

    boolean login(String userName, String password) {
        try {
            login.login(userName, password);
            common.createButton.waitUntil(exist, 5000);
            if (common.createButton.isDisplayed()) {
                return true;
            }
        } catch (Exception ignore) {
        }
        return false;
    }

    private void pauseReal(int sec){
        pause(sec*1000);
    }

    boolean createIssue(TestCase issue) {
        try {
            pauseReal(10);
            common.createButton.click();
            createPopup.issueTypeField.waitUntil(exist, 5000);
            if (!createPopup.issueTypeField.isDisplayed()) {
                return false;
            }
            createPopup.createIssue(issue.getType(), issue.getSummary(), issue.getLabels());
            pauseReal(10);
            do {
                common.issuesMenu.click();
                pause(1000);
            }while (!common.recentIssues.get(0).isDisplayed());
            pauseReal(10);
            common.recentIssues.get(0).click();
//            open(Configuration.baseUrl+"/browse/OBM-2622");
            testCase.step.waitUntil(exist, 5000);
            if (!testCase.step.isDisplayed()) {
                return false;
            }
            for (List<String> data : issue.getSteps()) {
                testCase.addStep(data);
                pause(1000);
                pauseReal(10);
            }
            String id = testCase.id.getText();
            open(Configuration.baseUrl+"/browse/"+issue.getRequirement());
            requirement.linkTestCase(id);
            pauseReal(10);
            return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void openNewTab(String url){
        pause(20000);
        switchTo().window(1);
        open(url);
    }
}

