
package com.mycompany.testwebapp.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import org.joda.time.DateTime;
import org.hibernate.annotations.Type;

/**
 *
 * @author eguseynov
 */
// This fields need to match with columns in table User, but table User must contain also another columns
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    private Integer id;
    
    private Integer version;

    private String email;
    
    //private String lname;
    
    private String lastName;
    
    private String fname;
    
    private DateTime birthDate;
    
    
    
    @Id
    @GeneratedValue(strategy = IDENTITY) // устанавливает id автоматически
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /*
    @Column(name="lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    */
    
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    
    @Column(name = "birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }
    
    
    @Version
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    @Column(name="lname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    

    @Override
    public String toString(){
        return "User {" + "id = " + id 
                + ", emai = " + email 
                + ", lname = " + lastName
                + ", fname= " + fname 
                + ", birthDate= " + birthDate 
                + "}";
    }
    
}
