package pl.lodz.childmotivationapp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by elawpio on 2017-12-11.
 */
@Entity
@Table
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int value;

    @OneToMany(mappedBy = "progress")
    private Set<User> users = new HashSet<>();

    @ManyToOne
    private Reward reward;

}
