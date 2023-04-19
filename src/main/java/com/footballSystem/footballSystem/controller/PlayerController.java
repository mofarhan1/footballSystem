package com.footballSystem.footballSystem.controller;

import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.service.PlayerService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody  Player player) {

        Player savedPlayer = playerService.save(player);

        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping("/getPlayers/{id}")
    public ResponseEntity<Player> getPlayers(@PathVariable Long id,@Valid @RequestBody Player player) {
        Player player1 =  playerService.getPlayer(id);
        return new ResponseEntity<>(player1, HttpStatus.OK);
    }

    @GetMapping("/getPlayer")
    public ResponseEntity<List<Player>> getPlayers(){

        List<Player> players =  playerService.getPlayers();

        return new ResponseEntity<>(players, HttpStatus.OK);
    }


}
