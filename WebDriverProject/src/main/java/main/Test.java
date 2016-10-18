package main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sergii_Chertkov on 9/29/2016.
 */
public class Test {
    public static WebDriver driver;

    public static String URL = "https://www.voyna-plemyon.ru/";
    public static String user = "Ордорг";
    public static String password = "voyna-plemyonPass1";




    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver", "D:/Projects/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1000,1200));

        byXpath(Element.login).sendKeys(user);
        byXpath(Element.password).sendKeys(password);
        byXpath(Element.loginButton).click();
        pause(2);
        byXpath(Element.selectWorld).click();
        pause(2);

        if(driver.findElements(By.xpath(Element.confirm_yes)).size()>0){
            byXpath(Element.confirm_yes).click();
            pause(2);
        }

        ArrayList<String> villages = findBarbarVillagesByRadius(1);
        ArrayList<String> attackVillages = attackVillages();
        villages.removeAll(attackVillages);
        for (String village:
                villages) {
            System.out.print(village+", ");
        }
        for (int i=0; i<villages.size();i++){
            if(!attack(villages.get(i)))
                break;
        }
//        pause(10);
//        driver.close();

/*
        driver.get("http://vuxdev2086.ondc.screwfix.local:9551/app/jsp/home.jsp");
        pause(5);

        byId("username").sendKeys("CCAUTHTEST.USER1");
        byId("password").sendKeys("Screwfix99");
        byId("login_button").click();
        pause(5);

        byId("email").sendKeys("test_serg@");
        byId("SEARCH_CUSTOMER_LINK").click();
        pause(3);

        byId("SELECT_CUSTOMER_BUTTON_LINK_RESULTS").click();
        pause(3);

        byId("EDIT_MEMBER_OF_STAFF").click();
        pause(3);

        byId("editCustomerProfileSubmit").click();
        pause(3);

        driver.navigate().refresh();

        byId("email").sendKeys("test_serg@");
        byId("SEARCH_CUSTOMER_LINK").click();
        pause(3);

        byId("SELECT_CUSTOMER_BUTTON_LINK_RESULTS").click();
        pause(3);

        byId("EDIT_MEMBER_OF_STAFF").click();
        pause(3);

        byId("editCustomerProfileSubmit").click();
        pause(3);
*/
    }


    public static ArrayList<String> findBarbarVillagesByRadius (int radius){
        byXpath(Element.mapLink).click();
        pause(3);
        ArrayList<String> villageID = new ArrayList<String>();

        villageID.addAll(findBarbarVillagesOnMap());
        if(radius>0){
            for(int r=1; r<=radius; r++){
                byXpath(Element.mapSouth).click();
                pause(3);
                villageID.addAll(findBarbarVillagesOnMap());
                for(int i=0; i<r*2-1; i++){
                    byXpath(Element.mapWest).click();
                    pause(3);
                    villageID.addAll(findBarbarVillagesOnMap());
                }
                for(int i=0; i<r*2; i++){
                    byXpath(Element.mapNorth).click();
                    pause(3);
                    villageID.addAll(findBarbarVillagesOnMap());
                }
                for(int i=0; i<r*2; i++){
                    byXpath(Element.mapEast).click();
                    pause(3);
                    villageID.addAll(findBarbarVillagesOnMap());
                }
                for(int i=0; i<r*2; i++){
                    byXpath(Element.mapSouth).click();
                    pause(3);
                    villageID.addAll(findBarbarVillagesOnMap());
                }
            }
        }
        villageID.remove("undefined");
        Set<String> hs = new HashSet<String>();
        hs.addAll(villageID);
        villageID.clear();
        villageID.addAll(hs);
        return villageID;
    }

    public static boolean attack(String id){
        driver.get(Element.villageURL+id);
        pause(3);
        byXpath(Element.sendTroops).click();
        pause(3);
        String allLight = byXpath(Element.unitsEntryAllLight).getText();
        allLight = allLight.substring(1,allLight.length()-1);
        if(Integer.valueOf(allLight)>=5){
            byXpath(Element.unitInputLight).sendKeys("5");
            pause(1);
            byXpath(Element.targetAttack).click();
            pause(3);
            byXpath(Element.troopConfirmGo).click();
            pause(3);
            System.out.println("village " + id + " have attacked");
            return true;
        }
        System.out.println("not enough units to attack "+id);
        return false;
    }

    public static ArrayList<String> findBarbarVillagesOnMap (){
        List<WebElement> villages = driver.findElements(By.xpath(Element.villagesOnMap));
        ArrayList<String> villageID = new ArrayList<String>();
        for (WebElement village:
                villages) {
            //System.out.println(village.getCssValue("background-color"));
            if(village.getCssValue("background-color").equals("rgba(0, 0, 0, 0)")) {
                villageID.add(village.getAttribute("id").substring(12));
                //System.out.println(village.getAttribute("id").substring(12));
            }
        }
        return villageID;
    }

    public static ArrayList<String> attackVillages (){
        driver.get("https://ru43.voyna-plemyon.ru/game.php");
        pause(2);
        List<WebElement> villages = driver.findElements(By.xpath(Element.attackVillages));
        ArrayList<String> villageUrls = new ArrayList<String>();
        //System.out.println(villages.size());
        for (WebElement village:
                villages) {
            //System.out.println(village.getAttribute("href"));
            villageUrls.add(village.getAttribute("href"));
        }
        ArrayList<String> villageID = new ArrayList<String>();
        for (String villageUrl:
                villageUrls) {
            driver.get(villageUrl);
            pause(2);
            //System.out.println(byXpath(Element.attackVillageId).getAttribute("data-id"));
            villageID.add(byXpath(Element.attackVillageId).getAttribute("data-id"));
        }
        return villageID;
    }

    public static WebElement byId(String id){
        return driver.findElement(By.id(id));
    }

    public static WebElement byXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public static void pause(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
