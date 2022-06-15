package obm.pages;

import com.codeborne.selenide.SelenideElement;
import obm.components.CommonElements;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DistributionsPage extends CommonElements {
    private SelenideElement addButton = $(By.xpath("//button/*[text()='add']"));
    private SelenideElement createListBasedDistributionButton = $(By.xpath("//*[text()='List based distribution']"));

    public NewListBasedDistributionPage startCreateListBasedDistribution(){
        addButton.waitUntil(exist, 10000);
        addButton.click();
        createListBasedDistributionButton.waitUntil(exist, 2000);
        createListBasedDistributionButton.click();
        return new NewListBasedDistributionPage();
    }
}
