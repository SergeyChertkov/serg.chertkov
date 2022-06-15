package obm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class createListDistribution {
    @BeforeClass
    static void init() {
        Configuration.baseUrl = "http://obm.tst.itsf.dc:30001/";
        Configuration.startMaximized = true;
        com.codeborne.selenide.Selenide.open("/");

        $(By.xpath("//*[@for='mat-radio-3-input']")).click();
        $(By.name("username")).waitUntil(exist, 10000).sendKeys("xm_uaa@xm-online.com.ua");
        $(By.name("password")).sendKeys("P@ssw0rd");
        $(By.xpath("//*[@class='xm-sign-up-form__button-wrapper']//*[@class='mat-button-wrapper']")).click();
    }

    @Test
    void deleteAllEntities() throws InterruptedException {

        $(By.xpath("//*[@placeholder='search']")).waitUntil(exist, 10000).sendKeys("cascade-");
        $(By.xpath("//*[@class='material-icons']")).click();
        $(By.xpath("//*[@class='material-icons']")).waitUntil(exist, 5000);
        ElementsCollection icons = $$(By.xpath("//*[@class='material-icons']"));
        do {
            try {
                icons.get(icons.size() - 1).click();
                $(By.xpath("//*[@class='swal2-confirm btn mat-button btn-primary']")).waitUntil(exist, 5000).click();
            } catch (Throwable e) {
                icons.get(icons.size() - 1).click();
                $(By.xpath("//*[@class='swal2-confirm btn mat-button btn-primary']")).waitUntil(exist, 5000).click();
            }
            $(By.xpath("//*[@class='close']")).waitUntil(exist, 25000);
            while ($$(By.xpath("//*[@class='close']")).size() > 0) {
                try {
                    $(By.xpath("//*[@class='close']")).click();
                    $(By.xpath("//*[@class='close']")).waitUntil(not(exist),1000);
                } catch (Throwable ignore) {
                    System.out.println(ignore.getStackTrace());
                }
            }
            icons = $$(By.xpath("//*[@class='material-icons']"));
        } while (icons.size() > 3);
    }

    @Test
    void createAndRunCorrect() {
//        List<String> numbers = Arrays.asList("380993314484", "380993314484", "380501111111");
        List<String> numbers = Arrays.asList("380993314484", "380668595829");
        createAndRun(numbers);
        Assert.assertEquals($$(By.xpath("//p[@class='marker success']")).get(0).getText(), "Submitted: " + numbers.size());
        Assert.assertEquals($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(0).getText(), "Failed: 0");
        Assert.assertEquals($$(By.xpath("//p[@class='marker success']")).get(1).getText(), "Delivered: " + numbers.size());
        Assert.assertEquals($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(1).getText(), "Failed: 0");
    }

    @Test
    void createAndRunIncorrect() {
        List<String> numbers = Arrays.asList("380993314484", "380993314484", "380380111111", "380501111111");
        createAndRun(numbers);
        Assert.assertEquals($$(By.xpath("//p[@class='marker success']")).get(0).getText(), "Submitted: " + (numbers.size() - 1));
        Assert.assertEquals($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(0).getText(), "Failed: 1");
        Assert.assertEquals($$(By.xpath("//p[@class='marker success']")).get(1).getText(), "Delivered: " + (numbers.size() - 1));
        Assert.assertEquals($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(1).getText(), "Failed: 1");
    }

    void createAndRun(List<String> numbers) {
        $(By.xpath("//*[@href='/dashboard/distributions']")).click();

        $(By.xpath("//button/*[text()='add']")).waitUntil(exist, 10000);
        $(By.xpath("//button/*[text()='add']")).click();
        $(By.xpath("//*[@class='modal-content']//*[text()='List based distribution']")).click();

        String date = new SimpleDateFormat("yyMMdd-HHmmss.SSS").format(new Date());
        $(By.name("distName")).sendKeys("test-list-" + date);
        $$(By.xpath("//mat-select")).get(0).click();
        $(By.xpath("//mat-option")).waitUntil(exist, 1000);
        $$(By.xpath("//mat-option")).get(0).click();
        $(By.xpath("//textarea")).sendKeys("Message for test " + date);

        addNumbers(numbers);

        $(By.xpath("//button[text()=' Create ']")).click();
        $(By.xpath("//button[text()='OK']")).waitUntil(exist, 10000);
        $(By.xpath("//button[text()='OK']")).click();

        //RUN
        $(By.xpath("//*[text()='test-list-" + date + "']")).click();
        $(By.xpath("//button[text()=' Run ']")).click();
        $(By.xpath("//button[contains(@class,'confirm')]")).click();
        pause(2);
        $(By.xpath("//button[contains(@class,'confirm')]")).click();

        $(By.xpath("//p[@class='marker success']")).waitUntil(exist, 10000);
        pause(5 + 5 * numbers.size());

        System.out.println($$(By.xpath("//p[@class='marker success']")).get(0).getText());
        System.out.println($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(0).getText());
        System.out.println($$(By.xpath("//p[@class='marker success']")).get(1).getText());
        System.out.println($$(By.xpath("//p[@class='marker failed ng-star-inserted']")).get(1).getText());
    }

    void addNumbers(List<String> numbers) {
        for (String number :
                numbers) {
            addNumber(number);
        }
    }

    void addNumber(String number) {
        $(By.xpath("//button/*[text()='add']")).click();
        $(By.xpath("//*[@placeholder='phone']")).sendKeys(number);
        $(By.xpath("//button//*[text()='Add']")).click();
    }

    void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
