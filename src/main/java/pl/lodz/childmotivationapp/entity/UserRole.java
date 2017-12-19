package pl.lodz.childmotivationapp.entity;

import javax.persistence.*;

/**
 * Created by elawpio on 2017-12-11.
 */
@Entity
@Table
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

/*
   @ManyToMany(mappedBy = "userRoles")
    private Set<User> employees = new HashSet<>();
*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


/*
    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }
*/


/*    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }*/
}
