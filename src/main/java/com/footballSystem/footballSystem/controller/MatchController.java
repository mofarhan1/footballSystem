package com.footballSystem.footballSystem.controller;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import com.footballSystem.footballSystem.model.ProPlayer;
import com.footballSystem.footballSystem.repository.MatchRepository;
import com.footballSystem.footballSystem.repository.PlayerParticipationRepository;
import com.footballSystem.footballSystem.repository.PlayerRepository;
import com.footballSystem.footballSystem.service.MatchService;
import com.footballSystem.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MatchController {
    private final MatchRepository matchRepository;
    private final PlayerParticipationRepository playerParticipationRepository;
    private final PlayerRepository playerRepository;
    private final MatchService matchService;

    public MatchController(MatchRepository matchRepository , MatchService matchService, PlayerParticipationRepository playerParticipationRepository,PlayerRepository playerRepository) {
        this.matchRepository =matchRepository;
        this.matchService =matchService;
        this.playerParticipationRepository =playerParticipationRepository;
        this.playerRepository =playerRepository;
    }


    @GetMapping("/getMatches")
    public ResponseEntity<List<Match>> getMatches(){
        List<Match> matches = matchService.getMatches();

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/getPlayerParticipations/{matchID}")
    public ResponseEntity<List<PlayerParticipation>> getPlayerParticipations(@PathVariable Long matchID){
      Match match =  matchRepository.findById(matchID).orElseThrow( ()->new ResourceNotFoundException("match not found"));
        return new ResponseEntity<>(match.getParticipationList(), HttpStatus.OK);
    }

    @PostMapping("/createMatch")
    public ResponseEntity<Match> saveMatch(@RequestBody Match match){

        Match msavedMatch =   matchService.saveMatch(match);

        return new ResponseEntity<>(msavedMatch, HttpStatus.OK);
    }

    @PostMapping("/createPlayerParticipation/{playerID}/{matchID}")
    public ResponseEntity<PlayerParticipation> createPlayerParticipation(@PathVariable Long playerID,@PathVariable Long matchID){
        PlayerParticipation playerParticipation = new PlayerParticipation();
        Player player = playerRepository.findById(playerID).orElseThrow( ()->new ResourceNotFoundException("Player not found"));
        Match match = matchRepository.findById(matchID).orElseThrow( ()->new ResourceNotFoundException("Match not found"));
        playerParticipation.setPlayer(player);
        match.getPlayerParticipationList().add(playerParticipation);

        PlayerParticipation savedPlayerParticipation =  playerParticipationRepository.save(playerParticipation);


        return new ResponseEntity<>( savedPlayerParticipation, HttpStatus.OK);
    }

    @GetMapping("/getSalary/{playerID}")
    public ResponseEntity<Double> getSalary(@PathVariable Long playerID){
        double sal=0.0;
        Player player = playerRepository.findById(playerID).orElseThrow( ()->new ResourceNotFoundException("Player not found"));
        if( player instanceof ProPlayer){
             sal = ((ProPlayer)player).salary();

        }
        else {

            sal = player.salary();
        }

        return new ResponseEntity<>( sal, HttpStatus.OK);
    }




}
