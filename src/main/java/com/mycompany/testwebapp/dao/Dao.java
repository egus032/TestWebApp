
package com.mycompany.testwebapp.dao;

import com.mycompany.testwebapp.users.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

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
    
}
    

