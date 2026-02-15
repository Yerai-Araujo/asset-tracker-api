package com.at.asset_tracker.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.at.asset_tracker.domain.model.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    Optional<Portfolio> findByUserId(Long userId);
}
