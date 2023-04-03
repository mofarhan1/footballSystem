package com.footballSystem.footballSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "date")
    private LocalDate date;

    public Match(String location, LocalDate date, LocalTime time) {
        this.location = location;
        this.date = date;
        this.time = time;
    }

    @Column(name = "time")
    private LocalTime time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "match_id")
    private List<PlayerParticipation> playerParticipationList = new ArrayList<>();


    public List<PlayerParticipation> getParticipationList() {
        return new ArrayList<>(playerParticipationList);
    }
}

