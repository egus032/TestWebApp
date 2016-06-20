
package com.mycompany.testwebapp.users;

/**
 *
 * @author eguseynov
 */

// This class is designed for giving additional information from table User
public class UserInfo {
    
    private Integer id;
    
    private String telType;
    
    private String telNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    
    public String toString(){
        return "UserInfo {" + "id=" + id 
                + ", telType=" + telType
                + ", telNumber=" + telNumber
                + "}";
    }
    
}
