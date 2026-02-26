package com.at.asset_tracker.market.domain.exception;

public class MarketPriceProviderException extends RuntimeException {

    public MarketPriceProviderException(String message) {
        super(message);
    }

    public MarketPriceProviderException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
