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
public interface UserService {
    
    public User save(User user);
    public void delete(User user);
    public User findById(Integer id);
    public List<User> findByLastName(String lastName);
    public List<User> findAll();
    public List<User> findAllWithDetail();
    
}
