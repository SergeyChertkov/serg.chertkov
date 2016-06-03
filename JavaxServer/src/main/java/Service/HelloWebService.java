package Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Sergii_Chertkov on 6/3/2016.
 */
// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String getHelloString(String name);
}
