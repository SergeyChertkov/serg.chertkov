package com.site500px;

public class DynamicXpath implements IHaveAnXPath {
    private String xpath;

    public DynamicXpath (String xpath){
        this.xpath = xpath;
    }

    public String getXPath() {
        return this.xpath;
    }
}
