package com.tournament.demo.repository;

import com.tournament.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByTournamentIdByRoundAscSlotAsc(Long tournamentId);

    List<Match> findByTournamentIdAndRound(Long tournamentId, Integer round);

    // Used by advancement logic to find the specific next-round match to populate
    Optional<Match> findByTournamentIdAndRoundAndSlot(Long tournamentId, Integer round, Long slot);
}
