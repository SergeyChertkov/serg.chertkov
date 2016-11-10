package elements;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public enum Element implements IHaveAnXPath {

    PAGE_TITLE("page title","//title"),
    PHONE_TV_ELECTRONIC_LINK("Phone TV Electric link","//*[@data-title='Телефоны, ТВ и электроника']"),
    SMARTPHONE_LINK("Smartphone link","//*[contains(text(),'Доступные смартфоны')]"),
    PRODUCT_PAGINATION_1("page 1","//*[@page1]"),
    PRODUCT_PAGINATION_2("page 2","//*[@page2]"),
    PRODUCT_PAGINATION_3("page 3","//*[@page3]")
    ;

    private final String name;
    private final String xpath;

    private Element(String name, String xpath) {
        this.name = name;
        this.xpath = xpath;
    }

    public String getXPath() {
        return xpath;
    }

//    private Element(String xpath) {
//        this.name = "";
//        this.xpath = xpath;
//    }

    public static Element getEntryForElementName(String fieldNameToFind) {
        for (Element element : values()) {
            if (element.name.equals(fieldNameToFind)) {
                return element;
            }
        }
        throw new RuntimeException("Cannot find entry for fieldName: '" + fieldNameToFind + "'");
    }
}
