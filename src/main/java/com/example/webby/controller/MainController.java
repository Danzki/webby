package com.example.webby.controller;

import com.example.webby.domain.Driver;
import com.example.webby.domain.Team;
import com.example.webby.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TeamRepo teamRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Team> teams = teamRepo.findAll();

        model.put("teams", teams);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String shortName, @RequestParam String name,
                      Map<String, Object> model) {
        Team team = new Team(name, shortName);
        teamRepo.save(team);
        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String shortName,
                         Map<String, Object> model) {
        Iterable<Team> teams;

        if (shortName != null && !shortName.isEmpty()) {
            teams = teamRepo.findByShortName(shortName);
        } else {
            teams = teamRepo.findAll();
        }
        model.put("teams", teams);

        return "main";
    }
}
