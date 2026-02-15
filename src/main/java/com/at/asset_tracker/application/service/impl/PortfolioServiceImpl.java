package com.at.asset_tracker.application.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at.asset_tracker.application.service.PortfolioService;
import com.at.asset_tracker.application.service.PriceService;
import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.Portfolio;
import com.at.asset_tracker.domain.model.PortfolioItem;
import com.at.asset_tracker.domain.model.User;
import com.at.asset_tracker.domain.repository.AssetRepository;
import com.at.asset_tracker.domain.repository.PortfolioRepository;



@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final AssetRepository assetRepository;
    private final PriceService priceService;

    public PortfolioServiceImpl(
            PortfolioRepository portfolioRepository,
            AssetRepository assetRepository,
            PriceService priceService
    ) {
        this.portfolioRepository = portfolioRepository;
        this.assetRepository = assetRepository;
        this.priceService = priceService;
    }

    @Override
    public Portfolio createPortfolioForUser(User user) {
        Portfolio portfolio = new Portfolio(user);
        return portfolioRepository.save(portfolio);
    }

    @Override
    public void addAsset(Long userId, String symbol, BigDecimal quantity) {

        Portfolio portfolio = portfolioRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));

        Asset asset = assetRepository.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found"));

        PortfolioItem item = new PortfolioItem(portfolio, asset, quantity);

        portfolio.getItems().add(item);
    }

    @Override
    public void removeAsset(Long userId, String symbol) {

        Portfolio portfolio = portfolioRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));

        portfolio.getItems().removeIf(
                item -> item.getAsset().getSymbol().equals(symbol)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calculateTotalValue(Long userId) {

        Portfolio portfolio = portfolioRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));

        return portfolio.getItems().stream()
                .map(item -> {
                    BigDecimal price = priceService.getCurrentPrice(
                            item.getAsset().getSymbol()
                    );
                    return price.multiply(item.getQuantity());
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

