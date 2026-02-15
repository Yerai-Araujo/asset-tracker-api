package com.at.asset_tracker.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at.asset_tracker.application.service.AssetService;
import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;
import com.at.asset_tracker.domain.repository.AssetRepository;


@Service
@Transactional
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Asset createAsset(String symbol, AssetType type, AssetUnit unit) {

        if (assetRepository.existsBySymbol(symbol)) {
            throw new IllegalArgumentException("Asset already exists");
        }

        Asset asset = new Asset(symbol, type, unit);
        return assetRepository.save(asset);
    }

    @Override
    @Transactional(readOnly = true)
    public Asset getBySymbol(String symbol) {
        return assetRepository.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
}
