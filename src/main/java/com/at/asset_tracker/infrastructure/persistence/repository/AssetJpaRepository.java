package com.at.asset_tracker.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.asset_tracker.infrastructure.persistence.entity.AssetEntity;

public interface AssetJpaRepository
        extends JpaRepository<AssetEntity, Long> {

    boolean existsBySymbol(String symbol);
}
