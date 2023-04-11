package com.footballSystem.footballSystem.service;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import com.footballSystem.footballSystem.repository.MatchRepository;
import com.footballSystem.footballSystem.repository.PlayerParticipationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MatchService {

    private final PlayerParticipationRepository playerParticipationRepository;
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository ,PlayerParticipationRepository playerParticipationRepository) {
        this.playerParticipationRepository = playerParticipationRepository;
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Match match) {
        matchRepository.save(match);
        return matchRepository.save(match);
    }


    public List<Match> getMatches() {
        return  (List<Match>) matchRepository.findAll();
    }
}
