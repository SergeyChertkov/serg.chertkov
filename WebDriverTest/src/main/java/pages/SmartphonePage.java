package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public class SmartphonePage extends ProductCatalogPage {

    public SmartphonePage(WebDriver driver) {
        super(driver);
        url = "http://rozetka.com.ua/mobile-phones/c80003/filter/preset=budget_smartphones/";
    }
}
