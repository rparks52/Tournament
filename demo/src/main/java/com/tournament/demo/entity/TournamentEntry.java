package com.tournament.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "tournament_entries",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"tournament_id", "team_id"}),
                @UniqueConstraint(columnNames = {"tournament_id", "seed"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TournamentEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer seed;

}
