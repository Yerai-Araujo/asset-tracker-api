package com.at.asset_tracker.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.at.asset_tracker.domain.model.PortfolioItem;


public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
}
