
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.Dao;
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
        Dao dao = gx.getBean("dao", Dao.class);
        System.out.println("First name is : " + dao.findFirstNameByid(3));
      
    }

    
}
