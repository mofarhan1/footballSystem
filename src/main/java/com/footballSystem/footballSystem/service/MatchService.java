package com.footballSystem.footballSystem.service;

import com.footballSystem.ResourceNotFoundException;
import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import com.footballSystem.footballSystem.model.ProPlayer;
import com.footballSystem.footballSystem.repository.MatchRepository;
import com.footballSystem.footballSystem.repository.PlayerParticipationRepository;
import com.footballSystem.footballSystem.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final PlayerParticipationRepository playerParticipationRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public MatchService(MatchRepository matchRepository ,PlayerParticipationRepository playerParticipationRepository,PlayerRepository playerRepository) {
        this.playerParticipationRepository = playerParticipationRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    public Match saveMatch(Match match) {
        matchRepository.save(match);
        return matchRepository.save(match);
    }


    public List<Match> getMatches() {
        return  (List<Match>) matchRepository.findAll();
    }

    public PlayerParticipation createPlayerParticipation(Long playerID, Long matchID) {
        PlayerParticipation playerParticipation = new PlayerParticipation();
        Player player = playerRepository.findById(playerID).orElseThrow( ()->new ResourceNotFoundException("Player not found"));
        Match match = matchRepository.findById(matchID).orElseThrow( ()->new ResourceNotFoundException("Match not found"));
        playerParticipation.setPlayer(player);
        match.getPlayerParticipationList().add(playerParticipation);

        PlayerParticipation savedPlayerParticipation =  playerParticipationRepository.save(playerParticipation);
        return savedPlayerParticipation;
    }


    public double getSalary(Long playerID) {
        double sal=0.0;
        Player player = playerRepository.findById(playerID).orElseThrow( ()->new ResourceNotFoundException("Player not found"));
        if( player instanceof ProPlayer){
            sal = ((ProPlayer)player).salary();

        }
        else {

            sal = player.salary();
        }
        return sal;
    }

    public List<PlayerParticipation> getPlayerParticipationsForMatch(Long matchID) {
        Match match =  matchRepository.findById(matchID).orElseThrow( ()->new ResourceNotFoundException("match not found"));
        List<PlayerParticipation> playerParticipations = match.getParticipationList();
        return playerParticipations;
    }
}
