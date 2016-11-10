package pages;

import database.DataBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public class ProductCatalogPage extends Page{

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void saveTopProductToDB (String name, String price){
        DataBase.connect();
        DataBase.execute("INSERT INTO PRODUCTS (name, price) " +
                "VALUES ('" + name + "'," + price + ")");
        DataBase.close();
    }
}
