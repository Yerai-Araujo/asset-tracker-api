package com.at.asset_tracker.infrastructure.external.market.dto;

import java.math.BigDecimal;
import java.util.Map;

public record CoinGeckoResponse(
        Map<String, Map<String, BigDecimal>> data
) {}