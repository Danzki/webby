package com.example.webby.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer teamId;
    private String name;
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;


    public Team() {
    }

    public Team(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}



