package com.footballSystem.footballSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotBlank(message = "Location is required")
    private String location;

    @Column(name = "date")
    @NotNull(message = "date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public Match(String location, LocalDate date, LocalTime time) {
        this.location = location;
        this.date = date;
        this.time = time;
    }

    @Column(name = "time")
    @NotNull(message = "time is required")
    private LocalTime time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "match_id")
    @JsonIgnore
    private List<PlayerParticipation> playerParticipationList = new ArrayList<>();


    public List<PlayerParticipation> getParticipationList() {
        return new ArrayList<>(playerParticipationList);
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}

