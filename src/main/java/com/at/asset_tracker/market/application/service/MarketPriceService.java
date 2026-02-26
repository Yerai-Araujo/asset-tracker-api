package com.at.asset_tracker.market.application.service;

import java.math.BigDecimal;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.at.asset_tracker.market.infrastructure.CompositeMarketPriceProvider;
import com.at.asset_tracker.portfolio.domain.model.enums.AssetType;

@Service
public class MarketPriceService {

    private final CompositeMarketPriceProvider provider;

    public MarketPriceService(CompositeMarketPriceProvider provider) {
        this.provider = provider;
    }

    @Cacheable(value = "marketPrices", key = "#symbol + '_' + #type")
    public BigDecimal getCurrentPrice(String symbol, AssetType type) {
        return provider.getCurrentPrice(symbol, type);
    }
}
