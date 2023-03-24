package com.footballSystem.footballSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pro_players")
public class ProPlayer extends Player {

    @Column(name = "match_fee")
    private double matchFee;


}
