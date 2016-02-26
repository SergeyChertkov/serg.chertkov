package com.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Math.random;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class App {
    private Client client;
    private EventLoger eventLogger;
    private Event event;

    public static void main (String[] args){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("com.epam.spring.core.App");

        for(int i=0; i<10; i++) {
            app.logEvent("Some event for user " + String.valueOf((int) (random()*3)));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ctx.close();
    }
    private void logEvent(String msg){
        String message = msg.replaceAll(this.client.getId(),this.client.getFullName());
        this.event.setMsg(message);
        this.eventLogger.logEvent(this.event);
    }

    public App(Client client, EventLoger eventLogger, Event event){
        this.client = client;
        this.eventLogger = eventLogger;
        this.event = event;
    }

}
