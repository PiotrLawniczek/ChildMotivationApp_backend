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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", value=" + value +
                ", users=" + users +
                ", reward=" + reward +
                '}';
    }
}
