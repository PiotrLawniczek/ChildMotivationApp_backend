package pl.lodz.childmotivationapp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by elawpio on 2017-12-11.
 */
@Entity
@Table
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
    private int price;

    @OneToMany(mappedBy = "reward", fetch = FetchType.EAGER)
    private Set<Progress> progresses = new HashSet<>();

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(Set<Progress> progresses) {
        this.progresses = progresses;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", progresses=" + progresses +
                '}';
    }
}
