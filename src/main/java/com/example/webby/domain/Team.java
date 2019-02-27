package com.example.webby.domain;

import javax.persistence.*;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer teamId;
    private String Name;
    private String ShortName;

    public Team() {
    }

    public Team(String name, String shortName) {
        Name = name;
        ShortName = shortName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

}



