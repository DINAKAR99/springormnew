package cgg.core.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", city=" + city + "]";
    }

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Id
    @Column(name = "user_id")
    private int id;
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    private String city;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
