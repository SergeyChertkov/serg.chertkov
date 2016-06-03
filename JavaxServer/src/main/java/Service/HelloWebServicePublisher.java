package Service;

import javax.xml.ws.Endpoint;

/**
 * Created by Sergii_Chertkov on 6/3/2016.
 */
public class HelloWebServicePublisher {
    public static void main(String... args) {
        // запускаем веб-сервер на порту 1986
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());
    }
}
