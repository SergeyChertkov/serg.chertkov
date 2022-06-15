package jira;

import com.codeborne.selenide.Configuration;
import jira.data.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateTestCase {
    private Jira jira = new Jira();

    @BeforeClass
    static void init() throws InterruptedException {
        Configuration.baseUrl = "https://jira.vodafone.ua:8443";
        Configuration.startMaximized = true;
        open("/");
        Thread.sleep(20000);
    }

    @Test
    void createTestCase() {
        List<TestCase> testCases = TestCase.getTestCasesFromFile("src/main/resources/testcases/testcases");
        jira.login("sechertkov", "pass");
        for (TestCase issue : testCases) {
            jira.createIssue(issue);
            System.out.println(issue.getSummary());
        }
    }

    @Test
    void moveResult() {
        String from = "/secure/ShowTestCycleRunDetail.jspa?cycleId=466&tpId=171377";
        String to = "/secure/ShowTestCycleRunDetail.jspa?cycleId=495&tpId=171377";

        jira.login("sechertkov", "eA3&tvlmuo2");
        open(from);
        jira.openNewTab(to);

        jira.pause(2000);
        switchTo().window(0);
    }
}
