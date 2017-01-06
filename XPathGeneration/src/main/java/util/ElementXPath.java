package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElementXPath {
    private WebDriver driver;
    private WebElement element;
    private List<String> tags;
    private List<String> xpathes;

    public static final String [] remove_items = {"onclick", "href", "src", "width", "height", "rel"};
    public static final String [] priorities = {"id", "name", "class"};

    public ElementXPath(WebDriver driver, WebElement element){
        this.driver = driver;
        this.element = element;
    }

    public List<String> getTags(){
        if(this.tags!=null) return this.tags;
        this.tags = new ArrayList<String>();
        String outerHTML = element.getAttribute("outerHTML").split(">")[0].substring(1);
        while (true) {
            if (outerHTML.indexOf("\"") < 0)
                break;
            String first = outerHTML.substring(0, outerHTML.indexOf("\"") - 1);
            String second = outerHTML.substring(outerHTML.indexOf("\"") + 1);
            if (second.indexOf("\"") < 0){
                outerHTML = first;
                break;
            }
            second = second.substring(second.indexOf("\"") + 1);
            if (outerHTML.length() == (first + second).length())
                break;
            outerHTML = first + second;
        }

        String[] tags = outerHTML.split(" ");
        for (int i = 1; i < tags.length; i++)
            this.tags.add(tags[i]);

        for (String remove_item:
             remove_items) {
            this.tags.remove(remove_item);
        }

        int index = 0;

        for (String priority:
             priorities) {
            if (this.tags.contains(priority)) {
                this.tags.remove(priority);
                this.tags.add(index, priority);
                index++;
            }
        }
        return this.tags;
    }
    
    public List<String> getXpathes(){
        if(this.xpathes!=null) return this.xpathes;
        this.getTags();
        this.xpathes =  new ArrayList<String>();

        this.xpathes.add("//" + element.getTagName());
        for (String tag:
             this.tags) {
            this.xpathes.add("//" + element.getTagName() + "[@" + tag + "='" + element.getAttribute(tag) + "']");
        }
        return this.xpathes;
    }
    
    public String getUniqueXpath(){
        this.getXpathes();
        String uniqueXpath;
        for (String xpath:
             this.xpathes) {
            uniqueXpath = getXpathIfUnique(xpath);
            if (uniqueXpath != null)
                return uniqueXpath;
        }
        ElementXPath parent = new ElementXPath(driver, element.findElement(By.xpath("parent::*")));
        List<String> parent_xpathes = parent.getXpathes();
        for (String parent_xpath:
                parent_xpathes){
            for (String xpath:
                    this.xpathes) {
                uniqueXpath = getXpathIfUnique(parent_xpath + xpath.substring(1));
                if (uniqueXpath != null)
                    return uniqueXpath;
            }

            for (String xpath:
                    this.xpathes) {
                parent_xpath = parent.getUniqueXpath();
                uniqueXpath = getXpathIfUnique(parent_xpath + xpath.substring(1));
                if (uniqueXpath != null)
                    return uniqueXpath;
            }
        }
        return null;
    }

    private String getXpathIfUnique(String xpath){
        if(driver.findElements(By.xpath(xpath)).size()==1)
            return optimizeUniqueXpath(xpath);
        return optimizeUniqueXpath(getXpathIfCountable(xpath));
    }

    private String getXpathIfCountable(String xpath){
        if(driver.findElements(By.xpath(xpath + "[1]")).size()==1) {
            int count = driver.findElements(By.xpath(xpath)).size();
            for (int i = 1; i <= count; i++)
                if (element.equals(driver.findElement(By.xpath(xpath + "[" + i + "]"))))
                    return xpath + "[" + i + "]";
        }
        return null;
    }

    private String optimizeUniqueXpath(String xpath){
        if(xpath == null)
            return xpath;
        String [] part = xpath.substring(2).split("/");
        String result = xpath;
        for (int i=0; i<part.length-1; i++) {
            if(!part[i].contains("[") &&
                    driver.findElements(By.xpath(removePartFromXpath(result,part[i]))).size()==1){
                result = removePartFromXpath(result,part[i]);
            }
        }
        return result;
    }

    private String removePartFromXpath(String xpath, String remove){
        String result = xpath.replace("/"+remove+"/","//");
        while (result.contains("///"))
            result = result.replaceAll("///","//");
        return result;
    }

    public String getUniqueName(){
        return getUniqueName(this.element);
    }

    public String getUniqueName(WebElement element){
        String name;
        String [] tags;

        tags = new String []{"id", "name", "title"};
        for (String tag:
             tags) {
            name = element.getAttribute(tag);
            if(name != null && name.length() > 3)
                return util.Translit.generateName(name);
        }

        name = element.getText();
        if(name != null && name.length() > 3)
            return util.Translit.generateName(name);

        name = getAnyText(element);
        if(name != null && name.length() > 3)
            return util.Translit.generateName(name);

        List <WebElement> children = element.findElements(By.xpath(".//*"));
        for (WebElement child:
             children) {
            name = getUniqueName(child);
            if(name != null && name.length() > 3)
                return util.Translit.generateName(name);
        }

        tags = new String [] {"class"};
        for (String tag:
                tags) {
            name = element.getAttribute(tag);
            if(name != null && name.length() > 3)
                return util.Translit.generateName(name);
        }

        return null;
    }

    public String getAnyText(WebElement element){
        String text = element.getAttribute("outerHTML");
        text = removeTags(text);
        text = util.Translit.generateName(text);
        if(text!=null && text.length()>3)
            return text;
        text = removeTags(element.findElement(By.xpath("..")).getAttribute("outerHTML"));
        return util.Translit.generateName(text);
    }

    public String removeTags (String text){
        if(text.length()>1000)
            return "";
        int start, end;
        start = text.indexOf('<');
        end = text.indexOf('>')+1;
        while (start >= 0 && end >= 1) {
            text = text.replace(text.substring(start,end),"");
            start = text.indexOf('<');
            end = text.indexOf('>')+1;
            while(start>end && end>0){
                text = text.replace(">","");
                end = text.indexOf('>')+1;
            }
        }
        return text;
    }

    public static List<String> generateNamesAndXpathes (WebDriver driver){
        List<WebElement> elements = new ArrayList<WebElement>();
        List<String> result = new ArrayList<String>();
        String str;

        elements.addAll(driver.findElements(By.xpath("//*[@href]")));
        elements.addAll(driver.findElements(By.xpath("//button")));
        elements.addAll(driver.findElements(By.xpath("//input")));
        elements.addAll(driver.findElements(By.xpath("//select")));

        int time = (int) (new Date()).getTime()+1000;
        for(int i=0; i<elements.size(); i++){
            ElementXPath elXpath = new ElementXPath(driver, elements.get(i));
            String xpath = elXpath.getUniqueXpath();
            String name = elXpath.getUniqueName();
            if(name != null && name.length() > 3)
                name = name.replaceAll(" ", "_");
            str = generateNamePrefix(elements.get(i)) + name + "\t" + xpath;
            result.add(str);
            if(time < (int) (new Date()).getTime()){
                time = (int) (new Date()).getTime()+5000;
                System.out.println(100*i/elements.size() + "%");
            }
        }
        return result;
    }

    private static String generateNamePrefix (WebElement element){
        String tag = element.getTagName();
        if(tag.equals("input")) {
            String type = element.getAttribute("type");
            if (type.equals("checkbox")) {
                return "CHECKBOX_";
            } else if (type.equals("radio")) {
                return "RADIOBUTTON_";
            } else {
                return "FIELD_";
            }
        }
        else if(tag.equals("a")) {
            return "LINK_";
        }
        else if(tag.equals("button")) {
            return "BUTTON_";
        }
        else if(tag.equals("select")) {
            return "SELECTOR_";
        }
        else{
            return "";
        }
    }
}
