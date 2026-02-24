package com.at.asset_tracker.infrastructure.external.market.dto;

import java.math.BigDecimal;
import java.util.Map;

public record MetalsApiResponse(
        Map<String, BigDecimal> rates,
        String base,
        String date
) {}
