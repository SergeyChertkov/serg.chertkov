package Client;

import Service.HelloWebService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.Service;

/**
 * Created by Sergii_Chertkov on 6/3/2016.
 */
public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://Service/", "HelloWebServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService hello = service.getPort(HelloWebService.class);

        // Ура! Теперь можно вызывать удаленный метод
        System.out.println(hello.getHelloString("JavaRush"));
        System.out.println(hello.getSum(15, 23));
    }
}
