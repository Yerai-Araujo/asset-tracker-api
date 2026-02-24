package com.at.asset_tracker.application.dto.request;

import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAssetRequest(

        @NotBlank(message = "Symbol cannot be empty")
        String symbol,

        @NotNull(message = "Type is required")
        AssetType type,

        @NotNull(message = "Unit is required")
        AssetUnit unit,

        @NotBlank(message = "Name cannot be empty")
        String name
) {}
