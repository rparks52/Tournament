package com.tournament.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.YamlProcessor;

@Entity
@Table(name = "matches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    // round 1 = first round, increment toward the final
    @Column(nullable = false)
    private Integer round;

    // Position within the round, used to derive next match's slot
    @Column(nullable = false)
    private Integer slot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_a")
    private Team teamA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_b")
    private Team teamB;

    private Integer scoreA;
    private Integer scoreB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private Team winner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus status;

    // This is a concurrency control field - JPA auto-increments it
    // on every UPDATE and checks it in the WHERE clause. A stale write
    // throws OptimisticLockException instead of silently overwriting.
    @Version
    private Long version;

    public enum MatchStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

}
