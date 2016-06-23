
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

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
    
    private String lname;
    
    private String fname;
    
    private Set<UserInfo> userInfo = new HashSet<UserInfo>();
    
    private Set<Hobby> hobbies = new HashSet<Hobby>();
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
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
    
    @Column(name="lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    
    @Version
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Set<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }
    
    @ManyToMany
    @JoinTable(name = "hobby_detail", 
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn (name = "hobby_id") )
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    
    
    
    public void addUserInfo(UserInfo userInfo){
        userInfo.setUser(this);
        getUserInfo().add(userInfo);
    }
    
    public  void removeUserInfo(UserInfo userInfo){
        getUserInfo().remove(userInfo);
    }
    
    
    @Override
    public String toString(){
        return "User {" + "id = " + id 
                + ", emai = " + email 
                + ", lname = " + lname 
                + ", fname= " + fname 
                + "}";
    }
    
}
