package com.arkmedis.digipro.service.impl;



import com.arkmedis.digipro.entity.Team;
import com.arkmedis.digipro.repository.TeamRepository;
import com.arkmedis.digipro.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveOrUpdateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> getTeamById(Long teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public Optional<Team> getTeamByName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> getTeamsByManagerId(Long managerId) {
        return teamRepository.findByManagerUserId(managerId);
    }

    @Override
    public void deleteTeamById(Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
