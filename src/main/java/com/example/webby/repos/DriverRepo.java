package com.example.webby.repos;

import com.example.webby.domain.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepo extends CrudRepository<Driver, Integer> {
}
