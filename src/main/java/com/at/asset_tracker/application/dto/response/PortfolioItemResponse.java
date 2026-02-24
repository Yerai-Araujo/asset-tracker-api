package com.at.asset_tracker.application.dto.response;

import java.math.BigDecimal;


public record PortfolioItemResponse(
        Long id,
        Long assetId,
        BigDecimal quantity
) {}
