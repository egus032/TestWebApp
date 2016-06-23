
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.Dao;
import com.mycompany.testwebapp.dao.DaoInterface;
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
        DaoInterface daoInterface = gx.getBean("daoInterface", DaoInterface.class);
        listUsers(daoInterface.findAll());
        
    }
    
    private static void listUsers(List<User> users){
        System.out.println("");
        System.out.println("Listing user details:");
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }
    }

    
}
