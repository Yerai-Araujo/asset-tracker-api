package com.at.asset_tracker.application.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.at.asset_tracker.application.service.PriceService;

@Service
public class MockPriceService implements PriceService {

    @Override
    public BigDecimal getCurrentPrice(String symbol) {

        // Simulación básica
        return switch (symbol) {
            case "BTC" -> BigDecimal.valueOf(50000);
            case "ETH" -> BigDecimal.valueOf(3000);
            default -> BigDecimal.valueOf(100);
        };
    }
}
