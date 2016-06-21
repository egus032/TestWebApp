/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebapp.dao;

import com.mycompany.testwebapp.users.User;
import java.util.List;

/**
 *
 * @author eguseynov
 */
public interface DaoInterface {
    
    public List<User> findAll();
    public List<User> findByFirstName(String firstName);
    public String findLastNameByid(Integer id);
    public String findFirstNameByid(Integer id);
    public void insert(User user);
    public void update(User user);
    public void delete(Integer id);
    
    public List<User> findAllInfoInBothTable();
}
