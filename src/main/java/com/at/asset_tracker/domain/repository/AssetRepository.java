package com.at.asset_tracker.domain.repository;

import java.util.Optional;

import com.at.asset_tracker.domain.model.Asset;

public interface AssetRepository {

    Asset save(Asset asset);

    boolean existsBySymbol(String symbol);

    Optional<Asset> findById(Long id);

}


