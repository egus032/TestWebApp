
package com.mycompany.testwebapp.users;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eguseynov
 */
public class MainApp {
    
    public static final Logger log = LoggerFactory.getLogger(MainApp.class);
    
    private static final String URL_GET_ALL_CONTACTS = "http://localhost:8081/TestWebApp/user/listUsers";
    private static final String URL_GET_CONTACT_BY_ID = "http://localhost:8081/TestWebApp/user/(id}";
    private static final String URL_CREATE_CONTACT = "http://localhost:8081/TestWebApp/user/";
    private static final String URL_UPDATE_CONTACT = "http://localhost:8081/TestWebApp/user/{id}";
    private static final String URL_DELETE_CONTACT = "http://localhost:8081/TestWebApp/user/{id}";
    
    public static void main(String[] args) {
        
        GenericXmlApplicationContext gx = new GenericXmlApplicationContext();
        gx.load("file:/Users/eguseynov/Documents/NetBeansProjects/"
                + "TestWebApp/src/main/webapp/WEB-INF/root-context.xml");
        gx.refresh();
        
        User user;
        RestTemplate restTemplate = gx.getBean("restTemplate", RestTemplate.class);
        System.out.println("Testing retrieve all contacts: ");
        Users users = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Users.class);
        log.info(users.toString());
        listUsers(users);
    }
    
    private static void listUsers(Users users){
        for (User user : users.getUsers()) {
            System.out.println(user);
        }
        System.out.println("");
    }
    
    

    
}
