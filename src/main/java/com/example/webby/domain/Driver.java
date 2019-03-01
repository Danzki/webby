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
    //private User owner;

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Team> teams = new ArrayList<>();

    public Driver() {
    }

    public Driver(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
