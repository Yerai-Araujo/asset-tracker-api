package com.at.asset_tracker.application.dto.response;

import java.util.Set;


public record PortfolioResponse(
        Long id,
        Long userId,
        Set<PortfolioItemResponse> items
) {}
