package com.arkmedis.digipro.service;
import com.arkmedis.digipro.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    // Save or update a team
    Team saveOrUpdateTeam(Team team);

    // Find a team by its ID
    Optional<Team> getTeamById(Long teamId);

    // Find a team by its name
    Optional<Team> getTeamByName(String teamName);

    // Retrieve all teams
    List<Team> getAllTeams();

    // Find teams managed by a specific user
    List<Team> getTeamsByManagerId(Long managerId);

    // Delete a team by its ID
    void deleteTeamById(Long teamId);

}
