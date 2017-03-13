package com.site500px;

import java.io.FileInputStream;
import java.io.IOException;

public class Property {
    public static final String PATH_TO_PROPERTIES = "config.ini";

    public static String get(String propName){
        FileInputStream fileInputStream;
        java.util.Properties prop = new java.util.Properties();

        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            return prop.getProperty(propName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
