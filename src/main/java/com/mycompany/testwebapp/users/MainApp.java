
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
        /*
        в этом методе выводится в консоль значения, переданные в параметрах,
        в параметры передаем метод findAllWithDetail(), возвращаюший
        объект в виде списка User, а метод listUser его итерирует по условиям
        */
        
        // сначала создадим объект user
        User user = new User();
        // заполним все его поля через сеттеры
        user.setEmail("jackson@power.ru");
        user.setLname("Jackson");
        user.setFname("Cane");
        
        //теперь создадим объект userInfo, т.к. у него есть переопределенный
        // конструктор, вызываем сразу его
        UserInfo userInfo = new UserInfo("Mobile", "551-52-52");
        // добавим этот объект к объекту user
        user.addUserInfo(userInfo);
        // можем переопределить поля объекта userInfo
        userInfo = new UserInfo("Home", "103-10-22");
        user.addUserInfo(userInfo);
        
        
        daoInterface.save(user);
        
        /* Это из предудущей версии
        User user = daoInterface.findById(2);
        System.out.println("");
        System.out.println("User with id 2: " + user);
        */
        listUsers(daoInterface.findAllWithDetail());
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
