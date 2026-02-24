package com.at.asset_tracker.domain.model.market;

import java.math.BigDecimal;

import com.at.asset_tracker.domain.model.enums.AssetType;


public interface MarketPriceProvider {

    boolean supports(AssetType type);

    BigDecimal getCurrentPrice(String symbol, AssetType type);
}