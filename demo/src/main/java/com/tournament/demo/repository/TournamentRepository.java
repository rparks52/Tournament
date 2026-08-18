package com.tournament.demo.repository;

import com.tournament.demo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStatus(Tournament.TournamentStatus status);
}
