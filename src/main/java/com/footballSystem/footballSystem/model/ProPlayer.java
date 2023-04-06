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


    public ProPlayer(String name, String birthYear, double matchFee) {
        super(name, birthYear);
        this.matchFee = matchFee;
    }


    /*
    The salary for a pro player is the matchFee times the
    percentage of matches,the player has played out of the matches
    the player has been selected for.
   */
    public double salary() {
        double sal = 0.0;
        int numOfPLayed = 0;
        for (PlayerParticipation pp : this.getPlayerParticipations()) {
            if (!pp.isCancelled()) {
                numOfPLayed++;
            }
        }
        double percentage = (numOfPLayed*1.0 / this.getPlayerParticipations().size()*1.0)*100.0;
        sal = this.getMatchFee()*percentage;
        return sal;
    }
}
