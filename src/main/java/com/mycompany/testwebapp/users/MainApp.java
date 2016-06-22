
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.Dao;
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
        Dao dao = gx.getBean("dao", Dao.class);
        //System.out.println("First name is : " + dao.findFirstNameByid(3));
        
        /*
        создаем объект список с параметрами User через вызов 
        метода на объекте dao
        
        List<User> userWithDetail = dao.findAllInfoInBothTable();
        
        
        в цикле перебираем сначала объект user и выводим на печать,
        после проверяем, если каждый из созданных объктов user.getUserInfo
        существует, то в цикле выводим объекты userInfo
              
        for (User user : userWithDetail) {
            
            System.out.println(user);
            
            if (user.getUserInfo() != null) {
                for (UserInfo userInfo : user.getUserInfo()) {
                    System.out.println(userInfo);
                }
            }
            System.out.println();
        }
      */
    }

    
}
