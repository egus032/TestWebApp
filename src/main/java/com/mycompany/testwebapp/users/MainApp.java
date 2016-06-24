
package com.mycompany.testwebapp.users;

import com.mycompany.testwebapp.dao.UserServiceImplementation;
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
        UserService userService = gx.getBean("userService", UserService.class);
        listUsers(userService.findAllWithDetail());
    }
    
    /*
    1. итерация по списку User
    2. внутри итерации, если user.getUserInfo существует, то
    итерируем по Set<UserInfo>, выводя значения, подходящие
    к объекту user из соотвуствующей итерации
    3. аналогичный подход как в п.2 к user.getHobbies
    */
    private static void listUsers(List<User> users){
        System.out.println("");
        System.out.println("Listing user details:");
        for (User user : users) {
            System.out.println(user);
            
            if(user.getUserInfo() != null) {
                for (UserInfo userInfo : user.getUserInfo()) {
                    System.out.println(userInfo);
                }
            }
            if(user.getHobbies() != null) {
                for (Hobby hobby : user.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            
            System.out.println("");
        }
    }

    
}
