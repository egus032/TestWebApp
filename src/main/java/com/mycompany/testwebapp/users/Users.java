/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebapp.users;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author eguseynov
 */
public class Users implements Serializable {
    
    private List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    @Override
    public String toString(){
        return "User {" + " users " + users + " }";
    }
    
    
    
    
}
