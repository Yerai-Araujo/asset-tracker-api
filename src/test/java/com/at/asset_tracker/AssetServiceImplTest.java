package com.at.asset_tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.at.asset_tracker.application.service.impl.AssetServiceImpl;
import com.at.asset_tracker.domain.model.Asset;
import com.at.asset_tracker.domain.model.enums.AssetType;
import com.at.asset_tracker.domain.model.enums.AssetUnit;
import com.at.asset_tracker.domain.repository.AssetRepository;

@ExtendWith(MockitoExtension.class)
class AssetServiceImplTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetServiceImpl assetService;

    @Test
    void shouldCreateAssetSuccessfully() {

        when(assetRepository.existsBySymbol("BTC")).thenReturn(false);

        Asset savedAsset = new Asset("BTC", AssetType.CRYPTO, AssetUnit.BTC);

        when(assetRepository.save(any(Asset.class))).thenReturn(savedAsset);

        Asset result = assetService.createAsset("BTC", AssetType.CRYPTO, AssetUnit.BTC);

        assertEquals("BTC", result.getSymbol());

        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void shouldThrowExceptionIfAssetExists() {

        when(assetRepository.existsBySymbol("BTC")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                assetService.createAsset("BTC", AssetType.CRYPTO, AssetUnit.BTC)
        );

        verify(assetRepository, never()).save(any());
    }
}
