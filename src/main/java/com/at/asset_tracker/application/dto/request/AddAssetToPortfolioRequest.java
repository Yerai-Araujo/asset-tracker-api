package com.at.asset_tracker.application.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddAssetToPortfolioRequest(

    @NotBlank
    String symbol,

    @NotNull
    @DecimalMin(value = "0.00000001")
    BigDecimal quantity
) {}
