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
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
@CrossOrigin
@Validated
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
    public ResponseEntity<List<PlayerParticipation>> getPlayerParticipationsForMatch(@PathVariable Long matchID){
      List<PlayerParticipation> playerParticipations =  matchService.getPlayerParticipationsForMatch(matchID);
        return new ResponseEntity<>(playerParticipations, HttpStatus.OK);
    }



    @PostMapping("/createMatch")
    public ResponseEntity<Match> saveMatch(@Valid @RequestBody Match match) throws Exception{
        Match msavedMatch =   matchService.saveMatch(match);

        return new ResponseEntity<>(msavedMatch, HttpStatus.OK);
    }

    @PostMapping("/createPlayerParticipation/{playerID}/{matchID}")
    public ResponseEntity<PlayerParticipation> createPlayerParticipation(@PathVariable Long playerID,@PathVariable Long matchID){

        PlayerParticipation savedPlayerParticipation = matchService.createPlayerParticipation(playerID,matchID);

        return new ResponseEntity<>( savedPlayerParticipation, HttpStatus.OK);
    }

    @GetMapping("/getSalary/{playerID}")
    public ResponseEntity<Double> getSalary(@PathVariable Long playerID){
        double salary = matchService.getSalary(playerID);
        return new ResponseEntity<>( salary, HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("Validation error");
        return ResponseEntity.badRequest().body(errorMessage);
    }
}









