package com.site500px;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    private static WebDriver driver;

    public static void main(String[] args) {
        String login = "partyson@ukr.net", pass = "party72895";

        System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1400, 1000));

        driver.get("https://500px.com/home");
        getElement(Elements.LOG_IN).click();
        getElement(Elements.EMAIL_FIELD).sendKeys(login);
        getElement(Elements.PASS_FIELD).sendKeys(pass);
        getElement(Elements.LOG_IN_BUTTON).click();
        pause(5);

        driver.get("https://500px.com/fresh");
        pause(5);
        doing();

        driver.get("https://500px.com/upcoming");
        pause(5);
        doing();

        driver.close();
    }

    private static void doing() {
        int p = Integer.parseInt(Property.get("pause_to_look"));
        int photosCount = Integer.parseInt(Property.get("photos_count"));
        int likesForLike = Integer.parseInt(Property.get("likes_for_like"));
        int likesForComment = Integer.parseInt(Property.get("likes_for_comment"));

        for (int i = 1; i <= photosCount; i++) {
            new org.openqa.selenium.interactions.Actions(driver).moveToElement(linkPhoto(i)).perform();
            linkPhoto(i).click();
            pause(2);
            try {
                if (countOfLikes() > likesForLike) {
                    pause((int) (p + Math.random() * p));
                    getElement(Elements.LIKE_PHOTO).click();
                    if (countOfLikes() > likesForComment) {
                        getElement(Elements.COMMENT_PHOTO).sendKeys(generateComment());
                        getElement(Elements.COMMENT_PHOTO).sendKeys(Keys.ENTER);
                        pause(2);
                    }
                }
                getElement(Elements.CLOSE_PHOTO).click();
                pause(2);
            }catch (Exception e){
                pause(2);
                getElement(Elements.CLOSE_PHOTO).click();
                pause(2);
            }

        }
    }

    private static void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int countOfLikes() {
        return Integer.parseInt(getElement(Elements.LIKE_PHOTO).getText());
    }

    private static WebElement getElement(IHaveAnXPath element) {
        return driver.findElement(By.xpath(element.getXPath()));
    }

    private static List<WebElement> getElements(IHaveAnXPath element) {
        return driver.findElements(By.xpath(element.getXPath()));
    }

    private static WebElement linkPhoto(int number) {
        return driver.findElement(By.xpath(Elements.PHOTOS.getXPath() + "[" + number + "]"));
    }

    private static String generateComment() {
        String[] wow = {"Wow", "Awesome"};
        String[] adjective = {"Good", "Nice", "Excellent", "Suberbeautiful", "Suberb", "Great", "Brilliant",
                "Wonderful", "Fantastic", "Stunning", "Atmospheric", "Amazing", "Remarkable"};
        String[] pic_name = {"shot", "ph", "pic", "photo", "picture", "work"};

        String comment = adjective[(int) (Math.random() * adjective.length)] + " " + pic_name[(int) (Math.random() * pic_name.length)];
        if (Math.random() > 0.3) {
            comment = comment.toLowerCase();
        }
        comment += generateSymbols();
        return comment;
    }

    private static String generateSymbols() {
        int rand = (int) (Math.random() * 10);
        switch (rand) {
            case 0:
                return "!";
            case 1:
                return "!!";
            case 2:
                return "!!!";
            case 3:
                return ".";
            default:
                return "";
        }
    }
}
