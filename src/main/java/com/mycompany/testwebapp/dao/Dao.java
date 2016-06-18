
package com.mycompany.testwebapp.dao;

import com.mycompany.testwebapp.users.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author eguseynov
 */
public class Dao implements DaoInterface {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO user (email, password, lname, fname) VALUES (?,?,?,?)", user);
        System.out.println("Created record =" + user);
        
    }
    
    private static final class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setLastName(rs.getString("lname"));
            user.setFirstName(rs.getString("fname"));
            return user;
        }
        
        
    }
    
    
}
    

