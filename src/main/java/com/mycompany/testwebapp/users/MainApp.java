
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author eguseynov
 */
public class MainApp {
    
    public static void main(String[] args) {
        
        GenericXmlApplicationContext gx = new GenericXmlApplicationContext();
        gx.load("file:/Users/eguseynov/Documents/NetBeansProjects/TestWebApp/src/main/webapp/WEB-INF/root-context.xml");
        gx.refresh();
        UserService userService = gx.getBean("userService", UserService.class);
        
    }
    
    

    
}
