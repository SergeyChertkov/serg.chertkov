package obm.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class LeftMenu {
    SelenideElement distributions = $(By.xpath("//*[@href='/dashboard/distributions']"));

}
