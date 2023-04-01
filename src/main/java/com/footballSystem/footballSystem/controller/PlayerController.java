package com.footballSystem.footballSystem.controller;

import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService =  playerService;
    }

    @PostMapping("/createPlayer")
    public ResponseEntity<Player> createPlayer(@RequestBody  Player player) {

        Player savedPlayer = playerService.save(player);

        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getPlayers(){

        List<Player> players =  playerService.getPlayers();

        return new ResponseEntity<>(players, HttpStatus.OK);
    }


}
