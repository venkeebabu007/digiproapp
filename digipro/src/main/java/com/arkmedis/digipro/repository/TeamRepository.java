package com.arkmedis.digipro.repository;



import com.arkmedis.digipro.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Find team by its name
    Optional<Team> findByTeamName(String teamName);

    // Find all teams managed by a specific user
    List<Team> findByManagerUserId(Long managerId);


}
