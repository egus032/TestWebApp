
package com.mycompany.testwebapp.users;

import java.util.List;

/**
 *
 * @author eguseynov
 */
// This fields need to match with columns in table User, but table User must contain also another columns
public class User {
    
    private Integer id;
    
    private String email;
    
    private String lname;
    
    private String fname;
    
    private List<UserInfo> userInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }
    @Override
    public String toString(){
        return "User {" + "id=" + id 
                + ", emai=" + email 
                + ", lname" + lname 
                + ", fname" + fname 
                + "}";
    }
    
}
