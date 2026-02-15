package com.at.asset_tracker.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Index;


@Entity
@Table(
    name = "portfolio_items",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"portfolio_id", "asset_id"}
    ),
    indexes = {
        @Index(name = "idx_portfolio_item_portfolio", columnList = "portfolio_id"),
        @Index(name = "idx_portfolio_item_asset", columnList = "asset_id")
    }
)

public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @Column(nullable = false, precision = 19, scale = 8)
    private BigDecimal quantity;

    protected PortfolioItem() {}

    public PortfolioItem(Portfolio portfolio, Asset asset, BigDecimal quantity) {
        this.portfolio = portfolio;
        this.asset = asset;
        this.quantity = quantity;
    }

    public Asset getAsset() {
        return asset;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void increaseQuantity(BigDecimal amount) {
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = this.quantity.add(amount);
    }
}

