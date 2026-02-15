package com.at.asset_tracker.application.service;

import java.math.BigDecimal;

public interface PriceService {

    BigDecimal getCurrentPrice(String symbol);
}
