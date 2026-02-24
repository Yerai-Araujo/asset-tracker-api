// package com.at.asset_tracker;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.math.BigDecimal;
// import java.util.HashSet;
// import java.util.Optional;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.at.asset_tracker.application.service.PriceService;
// import com.at.asset_tracker.application.service.impl.PortfolioServiceImpl;
// import com.at.asset_tracker.domain.model.enums.AssetType;
// import com.at.asset_tracker.domain.model.enums.AssetUnit;
// import com.at.asset_tracker.domain.repository.AssetRepository;
// import com.at.asset_tracker.domain.repository.PortfolioRepository;
// import com.at.asset_tracker.infrastructure.persistence.entity.AssetEntity;
// import com.at.asset_tracker.infrastructure.persistence.entity.PortfolioEntity;
// import com.at.asset_tracker.infrastructure.persistence.entity.PortfolioItemEntity;

// @ExtendWith(MockitoExtension.class)
// class PortfolioServiceImplTest {

//     @Mock
//     private PortfolioRepository portfolioRepository;

//     @Mock
//     private AssetRepository assetRepository;

//     @Mock
//     private PriceService priceService;

//     @InjectMocks
//     private PortfolioServiceImpl portfolioService;

//     @Test
//     void shouldAddAssetToPortfolio() {

//         Long userId = 1L;

//         PortfolioEntity portfolio = new PortfolioEntity();

//         AssetEntity asset = new AssetEntity("BTC", AssetType.CRYPTO, AssetUnit.BTC);

//         when(portfolioRepository.findByUserId(userId))
//                 .thenReturn(Optional.of(portfolio));

//         when(assetRepository.findBySymbol("BTC"))
//                 .thenReturn(Optional.of(asset));

//         portfolioService.addAsset(userId, "BTC", BigDecimal.valueOf(2));

//         assertEquals(1, portfolio.getItems().size());

//         verify(portfolioRepository).findByUserId(userId);
//         verify(assetRepository).findBySymbol("BTC");
//     }

//     @Test
// void shouldCalculateTotalValue() {

//     Long userId = 1L;

//     PortfolioEntity portfolio = new PortfolioEntity();

//     AssetEntity btc = new AssetEntity("BTC", AssetType.CRYPTO, AssetUnit.BTC);

//     portfolio.addAsset(btc, BigDecimal.valueOf(2));

//     when(portfolioRepository.findByUserId(userId))
//             .thenReturn(Optional.of(portfolio));

//     when(priceService.getCurrentPrice("BTC"))
//             .thenReturn(BigDecimal.valueOf(50000));

//     BigDecimal result = portfolioService.calculateTotalValue(userId);

//     assertEquals(BigDecimal.valueOf(100000), result);
// }

// }
