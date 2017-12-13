package pl.lodz.childmotivationapp.entity;

import javax.persistence.*;

/**
 * Created by elawpio on 2017-12-11.
 */
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
    private String value;


}
