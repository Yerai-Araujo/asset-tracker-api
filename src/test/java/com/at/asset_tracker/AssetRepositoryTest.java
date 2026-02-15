package com.at.asset_tracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;
import com.at.asset_tracker.domain.repository.AssetRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;


@DataJpaTest
class AssetRepositoryTest {

    @Autowired
    private AssetRepository assetRepository;

    @Test
    void shouldFindAssetBySymbol() {
        Asset asset = new Asset("BTC", AssetType.CRYPTO, AssetUnit.BTC);
        assetRepository.save(asset);

        Optional<Asset> result = assetRepository.findBySymbol("BTC");

        assertTrue(result.isPresent());
        assertEquals("BTC", result.get().getSymbol());
    }
}

