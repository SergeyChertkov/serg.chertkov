package pages;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public class Page {
    protected String url = "";
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getUrl(){
        return url;
    }

    public Page open(){
        driver.get(url);
        return this;
    }

    public Page and(){
        return this;
    }

    public Page thenOnPage(Page expectedPage){
        return expectedPage;
    }

    protected By getElement(String elementName){
        return By.xpath(Element.getEntryForElementName(elementName).getXPath());
    }

    public Page clickOn(String elementName){
        driver.findElement(getElement(elementName)).click();
        return this;
    }

    public String getText(String elementName){
        String result = driver.findElement(getElement(elementName)).getText();
        return result;
    }

}
