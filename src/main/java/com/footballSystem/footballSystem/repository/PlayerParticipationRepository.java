package com.footballSystem.footballSystem.repository;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.PlayerParticipation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerParticipationRepository extends JpaRepository<PlayerParticipation,Long> {
    Optional<PlayerParticipation> findById(Long id);
}
