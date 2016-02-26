package com.epam.spring.core;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class Client {
    private String id;
    private String fullName;

    public Client(String ID, String NAME) {
        this.id = ID;
        this.fullName = NAME;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
