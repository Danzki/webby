package com.example.webby.domain;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer teamId;
    private String name;
    private String shortName;

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
}



