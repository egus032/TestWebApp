
package com.mycompany.testwebapp.users;

import java.util.Date;

/**
 *
 * @author eguseynov
 */

// This class is designed for giving additional information from table User
public class UserInfo {
    
    private Date regDay;
    
    private Date lastVisitUser;


    public Date getRegDay() {
        return regDay;
    }
    
    public UserInfo(Date regDay, Date lastVisitUser) {
        this.regDay = regDay;
        this.lastVisitUser = lastVisitUser;
    }

    public void setRegDay(Date regDay) {
        this.regDay = regDay;
    }

    public Date getLastVisitUser() {
        return lastVisitUser;
    }

    public void setLastVisitUser(Date lastVisitUser) {
        this.lastVisitUser = lastVisitUser;
    }
    
    public boolean ifEmpty(){
        return this.regDay == null || this.lastVisitUser == null;
    }
    
    
    
}
