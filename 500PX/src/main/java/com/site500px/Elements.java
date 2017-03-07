package com.site500px;

public enum Elements implements IHaveAnXPath{
    SIGN_UP_LINK("sign up link","//*[@class='button static_nav__signup']"),
    EMAIL_FIELD("email field","//*[@id='email']"),
    PASS_FIELD("pass field","//*[@id='password']"),
    SIGN_UP_BUTTON("sign up button","//*[@data-normal=\"Sign up\"]"),

    PHOTOS("photos","//*[@class='grid-container justified-gallery']/div[contains(@class,'photo')]"),
    ACTOR_NAME("actor name","//*[@class='attribution_region section']//*[@class='actor']"),

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

