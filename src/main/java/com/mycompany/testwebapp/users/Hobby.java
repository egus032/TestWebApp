
package com.mycompany.testwebapp.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author eguseynov
 */
@Entity
@Table(name="hobby")
public class Hobby implements Serializable {
    
    private String hobby;
    
    private Set<User> users = new HashSet<User>();
    
    @Id
    @Column(name="hobby_id")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @ManyToMany
    @JoinTable(name = "hobby_detail", joinColumns = @JoinColumn(name = "hobby_detail"), 
     inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Set<User> getUsers() {
        return users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    @Override
    public String toString(){
        return "Hobby " + getHobby();
    }
    
    
}
