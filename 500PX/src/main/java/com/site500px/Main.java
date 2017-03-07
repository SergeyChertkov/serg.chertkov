package com.site500px;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    private static WebDriver driver;

    public static void main (String [] args){
        String login = "partyson@ukr.net", pass = "party72895";

        System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://500px.com/home");
        getElement(Elements.SIGN_UP_LINK).click();
        getElement(Elements.EMAIL_FIELD).sendKeys(login);
        getElement(Elements.PASS_FIELD).sendKeys(pass);
        getElement(Elements.SIGN_UP_BUTTON).click();

        driver.get("https://500px.com/fresh");
        pause(5);

        driver.get("https://500px.com/upcoming");
        pause(5);

        driver.close();
    }

    private static void pause(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static WebElement getElement(IHaveAnXPath element){
        return driver.findElement(By.xpath(element.getXPath()));
    }
}
