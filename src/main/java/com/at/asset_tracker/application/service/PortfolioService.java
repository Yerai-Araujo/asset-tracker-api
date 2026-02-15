package com.at.asset_tracker.application.service;

import java.math.BigDecimal;

import com.at.asset_tracker.domain.model.Portfolio;
import com.at.asset_tracker.domain.model.User;

public interface PortfolioService {

    Portfolio createPortfolioForUser(User user);

    void addAsset(Long userId, String symbol, BigDecimal quantity);

    void removeAsset(Long userId, String symbol);

    BigDecimal calculateTotalValue(Long userId);
}
