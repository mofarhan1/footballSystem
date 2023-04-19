package com.footballSystem.footballSystem.service;

import com.footballSystem.ResourceNotFoundException;
import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(Player player) {

        return playerRepository.save(player);

    }


    public List<Player> getPlayers() {
        return  (List<Player>) playerRepository.findAll();
    }

    public Player getPlayer(Long id) {
        Player player =  playerRepository.findById(id).
                orElseThrow( ()->new ResourceNotFoundException("Player not found"));
        return player;
    }
}
