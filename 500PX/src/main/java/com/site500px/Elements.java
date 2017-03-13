package com.site500px;

public enum Elements implements IHaveAnXPath{
    LOG_IN("log in","//*[@class='static_nav__login']"),
    EMAIL_FIELD("email field","//*[@id='email']"),
    PASS_FIELD("pass field","//*[@id='password']"),
    LOG_IN_BUTTON("log in button","//*[@value='Log in']"),

    PHOTOS("photos","//*[@class='grid-container justified-gallery']/div[contains(@class,'photo')]"),

    ACTOR_NAME("actor name","//*[@class='attribution_region section']//*[@class='actor']"),
    LIKE_PHOTO("like photo","//*[@class='actions_region section']//*[@class='like-button']//a"),
    COMMENT_PHOTO("comment photo","//*[@class='new_comment']"),

    CLOSE_PHOTO("close photo","//*[@class='close']"),

    ;

    private final String name;
    private final String xpath;

    private Elements(String name, String xpath) {
        this.name = name;
        this.xpath = xpath;
    }

    public String getXPath() {
        return xpath;
    }

    public static IHaveAnXPath getEntryForElementName(String fieldNameToFind) {
        String [] part = fieldNameToFind.split("%");
        for (Elements element : values()) {
            if (element.name.toLowerCase().equals(part[0].toLowerCase())) {
                if(part.length>1)
                    return new DynamicXpath(String.format(element.getXPath(),part[1]));
                return element;
            }
        }
        throw new RuntimeException("Cannot find entry for fieldName: '" + fieldNameToFind + "'");
    }
}

