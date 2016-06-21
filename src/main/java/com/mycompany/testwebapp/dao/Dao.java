
package com.mycompany.testwebapp.dao;

import com.mycompany.testwebapp.users.User;
import com.mycompany.testwebapp.users.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author eguseynov
 */
public class Dao implements DaoInterface, InitializingBean {
    
    
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
              
        /*
        here informed that dataSource is jdbc, and will work with him need 
        through the jdbctemplate
        */
        this.template = template;
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findLastNameByid(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public String findFirstNameByid(Integer id) {
        return template.queryForObject("SELECT fname FROM user WHERE id = ? ", new Object[]{id}, String.class);
         
    }

    @Override
    public void insert(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
        if (template == null) {
            throw new BeanCreationException ( "Null JdbcTemplate on ContactDao");
        }
    }

    @Override
    public List<User> findAllInfoInBothTable() {
        return template.query("select c.id, c.email, c.lname, c.fname, t.id as user_info_id, t.tel_type, t.tel_number " +
"from user c left outer join user_info t on c.id = t.id;", new UserInfoAllInfoExtractor());
        
    }
    
    public static  final class UserInfoAllInfoExtractor implements ResultSetExtractor<List<User>>{

        @Override
        public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, User> map = new HashMap<Integer, User>();
            User user = null;
            /*
            через цикл перебираем весь ResultlSet, если rs есть, то создаем
            id, т.е. этот объект отвечает за движение по таблице             
            */
            while (rs.next()) {
                Integer id = rs.getInt("id");
                user = map.get(id);
                
                /*
                инициализируем объект user и устанавливаем его поля,
                записывая в них значения из объекта rs, согласно столбцу,
                в конце все это кладем в map связывая с id.
                */
                if(user == null) {
                    user = new User();
                    user.setId(id);
                    user.setEmail(rs.getString("email"));
                    user.setLname(rs.getString("lname"));
                    user.setFname(rs.getString("fname"));
                    user.setUserInfo(new ArrayList<UserInfo>());
                    map.put(id, user);
                }
                /*
                здесь описывается способ создания объекта из второй 
                таблицы, сначала создаем id этой таблицы заново как бы,
                после в объект userInfo пишем все поля через сеттеры, добавляем
                в конце объект userInfo через метод класса User к объекту user 
                */
                Integer idUserInfo = rs.getInt("user_info_id");
                if(idUserInfo > 0){
                    UserInfo userInfo = new UserInfo();
                    userInfo.setId(idUserInfo);
                    userInfo.setIdUserInfo(id);
                    userInfo.setTelType(rs.getString("tel_type"));
                    userInfo.setTelNumber(rs.getString("tel_number"));
                    user.getUserInfo().add(userInfo);
                }
                /*
                возвращаем массив списка из map.values(), который возвращает
                значение из map
                */
            } return new ArrayList<User> (map.values());
        }
        
    }
    
    
}
    

