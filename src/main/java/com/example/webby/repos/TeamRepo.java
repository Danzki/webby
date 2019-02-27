package com.example.webby.repos;

import com.example.webby.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository<Team, Integer> {
}
