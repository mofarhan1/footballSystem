package com.footballSystem.footballSystem.controller;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import com.footballSystem.footballSystem.repository.MatchRepository;
import com.footballSystem.footballSystem.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {
    private final MatchRepository matchRepository;
    private final MatchService matchService;

    public MatchController(MatchRepository matchRepository , MatchService matchService) {
        this.matchRepository =matchRepository;
        this.matchService =matchService;
    }


    @GetMapping("/getMatches")
    public ResponseEntity<List<Match>> getMatches(){
        List<Match> matches = matchService.getMatches();

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @PostMapping("/createMatch")
    public ResponseEntity<Match> saveMatch(@RequestBody Match match){

        Match msavedMatch =   matchService.saveMatch(match);


        return new ResponseEntity<>(msavedMatch, HttpStatus.OK);
    }

    @PostMapping("/createPlayerParticipation")
    public PlayerParticipation createPlayerParticipation(PlayerParticipation playerParticipation){
        PlayerParticipation playerParticipation1 = new PlayerParticipation();

        return playerParticipation1;

    }


}
