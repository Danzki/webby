package com.example.webby.controller;

import com.example.webby.domain.Driver;
import com.example.webby.domain.Team;
import com.example.webby.domain.User;
import com.example.webby.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String main(@RequestParam(required = false, defaultValue = "") String shortName,
                       Model model){
        Iterable<Team> teams = teamRepo.findAll();
        if (shortName != null && !shortName.isEmpty()) {
            teams = teamRepo.findByShortName(shortName);
        } else {
            teams = teamRepo.findAll();
        }
        model.addAttribute("teams", teams);
        model.addAttribute("shortName", shortName);

        return "main";
    }

    @PostMapping("/main")
    public String add(
                    @AuthenticationPrincipal User user,
                    @RequestParam String shortName,
                    @RequestParam String name,
                    Map<String, Object> model) {
        Team team = new Team(name, shortName);
        teamRepo.save(team);
        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);

        return "main";
    }

}
