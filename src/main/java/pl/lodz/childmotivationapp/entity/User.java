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

}
