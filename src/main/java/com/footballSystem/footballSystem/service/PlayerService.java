package com.footballSystem.footballSystem.service;

import com.footballSystem.ResourceNotFoundException;
import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import com.footballSystem.footballSystem.repository.PlayerParticipationRepository;
import com.footballSystem.footballSystem.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerParticipationRepository playerParticipationRepository;

    public PlayerService(PlayerRepository playerRepository, PlayerParticipationRepository playerParticipationRepository) {
        this.playerRepository = playerRepository;
        this.playerParticipationRepository = playerParticipationRepository;
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

    public Player GetPlayerforPlayerParticipation(Long playerParticipationID) {
        PlayerParticipation playerParticipation =  playerParticipationRepository.findById(playerParticipationID).orElseThrow( ()->new ResourceNotFoundException("playerParticipationID not found"));
        Player player =  playerRepository.findById(playerParticipation.getPlayer().getId()).orElseThrow( ()->new ResourceNotFoundException("player not found"));
        return player;
    }
}
