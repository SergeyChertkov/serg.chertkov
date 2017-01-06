import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ElementXPath;

import java.util.List;

public class Example {
    @Test
    public void testExample(){
        System.setProperty("webdriver.chrome.driver", "D:/Projects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rozetka.com.ua/");

        List<String> xpathes = ElementXPath.generateNamesAndXpathes(driver);
        for (String xpath : xpathes)
            System.out.println(xpath);

        driver.close();
    }
}
