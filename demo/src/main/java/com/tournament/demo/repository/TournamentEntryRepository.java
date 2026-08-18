package com.tournament.demo.repository;

import com.tournament.demo.entity.TournamentEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TournamentEntryRepository  extends JpaRepository<TournamentEntry,Long> {
    // Drives round-1 seeding order for bracket generation
    List<TournamentEntry> findByTournamentIdOrderBySeedAsc(Long tournamentId);

    Optional<TournamentEntry> findByTournamentIdAndTeamId(Long tournamentId, Long teamId);

    boolean existsByTournamentIdAndSeed(Long tournamentId, Integer seed);
}
