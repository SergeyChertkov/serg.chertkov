package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Sergii_Chertkov on 10/18/2016.
 */
public class Page {
    public String URL = "https://www.google.com.ua/";
    public WebDriver driver;



    public Page(WebDriver driver){
        this.driver = driver;
    }

    public Page open (){
        driver.get(URL);
        return this;
    }
    public void close (){
        driver.close();
    }

    public WebElement byId(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement byXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public void pause(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
