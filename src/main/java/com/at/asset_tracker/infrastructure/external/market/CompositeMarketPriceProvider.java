package com.at.asset_tracker.infrastructure.external.market;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.at.asset_tracker.domain.exception.MarketPriceProviderException;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.market.MarketPriceProvider;

@Primary
@Component
public class CompositeMarketPriceProvider implements MarketPriceProvider {

    private final List<MarketPriceProvider> providers;

    public CompositeMarketPriceProvider(List<MarketPriceProvider> providers) {
        this.providers = providers;
    }

    @Override
    public boolean supports(AssetType type) {
        return true;
    }


    public BigDecimal getCurrentPrice(String symbol, AssetType type) {

        return providers.stream()
                .filter(p -> p.supports(type))
                .findFirst()
                .orElseThrow(() -> new MarketPriceProviderException("No provider for type"))
                .getCurrentPrice(symbol, type);
    }
}
