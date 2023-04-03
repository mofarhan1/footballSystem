package com.footballSystem.footballSystem;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.model.ProPlayer;
import com.footballSystem.footballSystem.repository.MatchRepository;
import com.footballSystem.footballSystem.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public DatabaseInitializer(PlayerRepository playerRepository, MatchRepository matchRepository) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }


    @Override
    public void run(String... args) throws Exception {
       Player player1 = new Player("Mohammed","1989");
       Player player2 = new Player("Mike","1994");
       Player player3 = new Player("Hans","1980");
       Player player4 = new Player("Lars","1985");
       Player player5 = new ProPlayer("Christian","1980",5000);
       Player player6 = new ProPlayer("Mathias","1985",5500);
       playerRepository.saveAll(Arrays.asList(player1, player2, player3, player4,player5, player6));

       Match match1 = new Match("Randers", LocalDate.now().plusWeeks(1),LocalTime.of(12, 00, 00));
       Match match2 = new Match("Herning", LocalDate.now().plusWeeks(2),LocalTime.of(13, 00, 00));
       Match match3 = new Match("Ikast", LocalDate.now().plusWeeks(3),LocalTime.of(12, 00, 00));
       matchRepository.saveAll(Arrays.asList(match1, match2, match3));




    }
}