package com.at.asset_tracker.application.dto.request;


import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAssetRequest(

    @NotBlank
    String symbol,

    @NotNull
    AssetType type,

    @NotNull
    AssetUnit unit
) {}
