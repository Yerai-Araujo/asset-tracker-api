package com.at.asset_tracker.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.asset_tracker.application.dto.request.AddAssetToPortfolioRequest;
import com.at.asset_tracker.application.service.PortfolioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/{portfolioId}/assets")
    public void addAsset(
            @PathVariable Long portfolioId,
            @Valid @RequestBody AddAssetToPortfolioRequest request
    ) {
        portfolioService.addAsset(
                portfolioId,
                request.symbol(),
                request.quantity()
        );
    }
}
