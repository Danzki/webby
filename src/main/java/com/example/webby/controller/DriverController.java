package com.example.webby.controller;

import com.example.webby.domain.Driver;
import com.example.webby.domain.Team;
import com.example.webby.domain.User;
import com.example.webby.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DriverController {
    @Autowired
    private DriverRepo driverRepo;

    @GetMapping("/driver")
    public String driver(Map<String, Object> model){
        Iterable<Driver> drivers = driverRepo.findAll();

        model.put("drivers", drivers);
        return "driver";
    }

    @PostMapping("adddriver")
    public String adddriver(@AuthenticationPrincipal User user,
                            @RequestParam String name,
                            Map<String, Object> model) {
        Driver driver = new Driver(name, true, user);
        driverRepo.save(driver);
        Iterable<Driver> drivers = driverRepo.findAll();
        model.put("drivers", drivers);

        return "driver";
    }
}
