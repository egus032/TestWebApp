
package com.mycompany.testwebapp.dao;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author eguseynov
 */
public class Dao implements DaoInterface {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String addById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT fname FROM users WHERE id=?", new Object[]{id}, String.class);
    }
}
    

