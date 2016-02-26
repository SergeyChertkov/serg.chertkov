package com.epam.spring.core;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class ConsoleEventLogger implements EventLoger{
    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
