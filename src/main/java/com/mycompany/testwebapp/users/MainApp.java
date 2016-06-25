
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.UserService;
import java.util.List;
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
        /*
        создаем экзмепляр интерфейса через вызов бина по названию в строке и
        по определению класса в следующем параметре
        */
        UserService userService = gx.getBean("remoteUserService", UserService.class);
        System.out.println("Finding all contacts:");
        /*
        создаем список users используя вызов метода через объект, т.к. интерфейс
        свои методы не реализует, то он обращается к классу имплементу
        */
        List<User> users = userService.findAll();
        listUsers(users);
        
        System.out.println("Finding contact with first name equals Chris");
        users = userService.findByLastName("Chris");
        listUsers(users);
    }
    
    private static void listUsers(List<User> users){
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("");
    }
    
    

    
}
