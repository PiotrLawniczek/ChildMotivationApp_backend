package pl.lodz.childmotivationapp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by elawpio on 2017-12-11.
 */
@Entity
@Table(name = "tuser")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String firstName;
    private String lastName;


    @ManyToOne
    private Progress progress;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", progress=" + progress +
                ", userRoles=" + userRoles +
                '}';
    }

}
