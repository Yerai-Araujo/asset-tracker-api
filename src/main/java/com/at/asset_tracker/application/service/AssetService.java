package com.at.asset_tracker.application.service;

import java.util.List;

import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;

public interface AssetService {

    Asset createAsset(String symbol, AssetType type, AssetUnit unit);

    Asset getBySymbol(String symbol);

    List<Asset> getAllAssets();
}

