
package com.mycompany.testwebapp.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author eguseynov
 */

// This class is designed for giving additional information from table User
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {
    
    private Integer id;
    
    private Integer version;
    
    private String telType;
    
    private String telNumber;
    
    private User user;
    
    

    public UserInfo() {
    }

    public UserInfo(String telType, String telNumber) {
        this.telType = telType;
        this.telNumber = telNumber;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "tel_type")
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }
    
    @Column(name = "tel_number")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Version
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_user_info")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public String toString(){
        return "UserInfo {" + "id = " + id 
                + ", User id =  " + getUser().getId()
                + ", telType = " + telType
                + ", telNumber = " + telNumber
                + "}";
    }
    
}
