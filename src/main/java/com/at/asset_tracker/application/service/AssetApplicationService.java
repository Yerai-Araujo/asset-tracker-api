package com.at.asset_tracker.application.service;

import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;
import com.at.asset_tracker.domain.repository.AssetRepository;

@Service
@Transactional
public class AssetApplicationService {

    private final AssetRepository assetRepository;

    public AssetApplicationService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset create(String symbol, AssetType type, AssetUnit unit, String name) {

        if (assetRepository.existsBySymbol(symbol)) {
            throw new IllegalStateException("Asset already exists");
        }

        Asset asset = new Asset(null, symbol, type, unit, name);

        return assetRepository.save(asset);
    }

    @Transactional(readOnly = true)
    public Asset findById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found"));
    }

    @Transactional(readOnly = true)
    public boolean existsBySymbol(String symbol) {
        return assetRepository.existsBySymbol(symbol);
    }
}
