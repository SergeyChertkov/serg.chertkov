package main;

import org.openqa.selenium.WebElement;

/**
 * Created by Sergii_Chertkov on 10/3/2016.
 */
public class Element {
    public static String villageURL = "https://ru43.voyna-plemyon.ru/game.php?screen=info_village&id=";
    public static String villagePlayer = "//*[@valign='top']//tr[5]/td[2]";
    public static String sendTroops = "//*[@id='send_troops']";
    public static String unitInputLight = "//*[@id='unit_input_light']";
    public static String unitsEntryAllLight = "//*[@id='units_entry_all_light']";
    public static String targetAttack = "//*[@id='target_attack']";
    public static String troopConfirmGo = "//*[@id='troop_confirm_go']";

    public static String login = "//*[@id='user']";
    public static String password = "//*[@id='password']";
    public static String loginButton = "//*[@class='button_middle']";
    public static String selectWorld = "//*[@class='world_button_active']";


    public static String mapLink = "//*[@id='header_menu_link_map']";
    public static String confirm_yes = "//*[@class='btn btn-confirm-yes']";
    public static String attackVillages = "//*[@class='quickedit-content']/a";

    //public static String attackVillageId = "//tr[5]//*[@class='village_anchor contexted']";
    public static String attackVillageId = "//*[@class='vis']//tr[5]/td[2]/span";

    public static String villagesOnMap = "//*[contains(@id,'map_village')]";
    public static String mapNorth = "//*[@class='map_navigation']/*[@alt='map/map_n.png']";
    public static String mapSouth = "//*[@class='map_navigation']/*[@alt='map/map_s.png']";
    public static String mapWest = "//*[@class='map_navigation']/*[@alt='map/map_w.png']";
    public static String mapEast = "//*[@class='map_navigation']/*[@alt='map/map_e.png']";

}
