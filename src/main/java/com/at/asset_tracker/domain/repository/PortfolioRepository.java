package com.at.asset_tracker.domain.repository;

import java.util.Optional;

import com.at.asset_tracker.domain.model.Portfolio;


public interface PortfolioRepository {

    Portfolio save(Portfolio portfolio);

    Optional<Portfolio> findById(Long id);

    Optional<Portfolio> findByUserId(Long userId);
}

