import database.DataBase;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public class TestCase {
    WebDriver driver;

    @BeforeClass
    public static void createTable(){
        DataBase.connect();
        DataBase.execute("DROP TABLE PRODUCTS");
        DataBase.execute("CREATE TABLE PRODUCTS (" +
                "  id int(10) unsigned NOT NULL auto_increment," +
                "  name varchar(45) NOT NULL," +
                "  price double(45) NOT NULL," +
                "  PRIMARY KEY  (id)" +
                ")");
        DataBase.close();
    }

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "D:/Projects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void end(){
        driver.close();
    }

    @Test
    public void TestScenario(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        PhoneTVElectricPage phoneTVElectricPage = PageFactory.initElements(driver, PhoneTVElectricPage.class);
        SmartphonePage smartphonePage = PageFactory.initElements(driver, SmartphonePage.class);

        mainPage.open().and().clickOn("Phone TV Electric link").
                thenOnPage(phoneTVElectricPage).clickOn("Smartphone link").
                thenOnPage(smartphonePage);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
