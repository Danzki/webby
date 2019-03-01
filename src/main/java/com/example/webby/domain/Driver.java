package com.example.webby.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer driverId;
    private String name;
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Team> teams = new ArrayList<>();

    public Driver() {
    }

    public Driver(String name, boolean active, User user) {
        this.name = name;
        this.active = active;
        this.owner = user;
    }

    //TODO : function for setting active = false for all previous Driver of a user

    public String getOwnerName() {
        return owner != null ? owner.getUsername() : "<none>";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
