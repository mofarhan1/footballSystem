package com.footballSystem.footballSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "player_participations")
public class PlayerParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cancelled")
    private boolean cancelled;

    @Column(name = "reason")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;



    public PlayerParticipation() {
        this.cancelled = false;
        this.reason = null;
    }

    public PlayerParticipation(Boolean cancelled, String reason) {
        this.cancelled = cancelled;
        this.reason = reason;
    }


}

