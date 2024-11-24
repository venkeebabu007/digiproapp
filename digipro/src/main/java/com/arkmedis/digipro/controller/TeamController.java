package com.arkmedis.digipro.controller;


import com.arkmedis.digipro.entity.Team;
import com.arkmedis.digipro.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")

public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Create or update a team
    @PostMapping
    public ResponseEntity<Team> saveOrUpdateTeam(@RequestBody Team team) {
        Team savedTeam = teamService.saveOrUpdateTeam(team);
        return ResponseEntity.ok(savedTeam);
    }

    // Get a team by ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all teams
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    // Get teams by manager ID
    @GetMapping("/manager/{managerId}")
    public ResponseEntity<List<Team>> getTeamsByManagerId(@PathVariable Long managerId) {
        List<Team> teams = teamService.getTeamsByManagerId(managerId);
        return ResponseEntity.ok(teams);
    }

    // Delete a team by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.noContent().build();
    }


}
