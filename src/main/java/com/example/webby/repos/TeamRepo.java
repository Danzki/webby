package com.example.webby.repos;

import com.example.webby.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepo extends CrudRepository<Team, Integer> {
    List<Team> findByShortName(String shortName);

    List<Team> findByName(String name);
}
