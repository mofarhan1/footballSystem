package com.footballSystem.footballSystem.repository;

import com.footballSystem.footballSystem.model.Match;
import com.footballSystem.footballSystem.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long id);

}
