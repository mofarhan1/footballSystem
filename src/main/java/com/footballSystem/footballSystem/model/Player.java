package com.footballSystem.footballSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "players")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "player_type",
        discriminatorType = DiscriminatorType.STRING)

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message="name is required")
    private String name;

    public Player(String name, String birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Column(name = "birth_year")
    @NotBlank(message="birthYear is required")
    private String birthYear;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PlayerParticipation> playerParticipations = new ArrayList<>();


    /*
    The salary for an ordinary player is 20 times the number of played matches.
     */
    public double salary() {
        int numOfPLayed = 0;
        for (PlayerParticipation pp : this.playerParticipations) {
            if (!pp.isCancelled()) {
                numOfPLayed++;
            }
        }
        return 20.0*numOfPLayed;
    }
}
