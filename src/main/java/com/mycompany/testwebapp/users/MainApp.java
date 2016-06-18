
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author eguseynov
 */
public class MainApp {
    
    public static void main(String[] args) {
        
        User user = new User();
        ApplicationContext context = 
             new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/root-context.xml");
      
        Dao dao = (Dao) context.getBean("dao");
        System.out.println("Database contains");
        dao.insertUser(user);
        
      
    }

    
}
