package com.at.asset_tracker.application.dto.response;

import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;

public record AssetResponse(
    Long id,
    String symbol,
    AssetType type,
    AssetUnit unit
) {}

