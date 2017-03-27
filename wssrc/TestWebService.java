

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.app.showpic.ws.webservice.XxnWebService;


public class TestWebService {
    private WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
    private XxnWebService xxnWebService =  (XxnWebService) context.getBean(XxnWebService.class);
    
    public String sayhello(String name){
    	return xxnWebService.sayhello(name);
    }
}
