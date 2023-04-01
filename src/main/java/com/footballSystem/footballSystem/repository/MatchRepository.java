package com.footballSystem.footballSystem.repository;

import com.footballSystem.footballSystem.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findById(Long id);

}
