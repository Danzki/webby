package com.example.webby;

import com.example.webby.domain.Team;
import com.example.webby.repos.DriverRepo;
import com.example.webby.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController<postmapping> {
    @Autowired
    private TeamRepo teamRepo;
    private DriverRepo driverRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Team> teams = teamRepo.findAll();

        model.put("teams", teams);
        return "main";
    }

    @PostMapping
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

    @GetMapping("/driver")
    public String driver(
            @RequestParam(name="shortName", required=false, defaultValue="All") String shortName,
            Map<String, Object> model
    ) {
        Iterable<Team> teams;
        teams = teamRepo.findByShortName(shortName);
        String name=teams.iterator().next().getName();
        model.put("name", name);

        return "driver";
    }

}
