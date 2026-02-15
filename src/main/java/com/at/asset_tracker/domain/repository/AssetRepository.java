package com.at.asset_tracker.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.at.asset_tracker.domain.model.Asset;


public interface AssetRepository extends JpaRepository<Asset, Long> {

    Optional<Asset> findBySymbol(String symbol);

    boolean existsBySymbol(String symbol);
}

