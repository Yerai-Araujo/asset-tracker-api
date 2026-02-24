// package com.at.asset_tracker;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.at.asset_tracker.domain.model.enums.AssetType;
// import com.at.asset_tracker.domain.model.enums.AssetUnit;
// import com.at.asset_tracker.domain.repository.AssetRepository;
// import com.at.asset_tracker.infrastructure.persistence.entity.AssetEntity;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import java.util.Optional;


// @DataJpaTest
// class AssetRepositoryTest {

//     @Autowired
//     private AssetRepository assetRepository;

//     @Test
//     void shouldFindAssetBySymbol() {
//         AssetEntity asset = new AssetEntity("BTC", AssetType.CRYPTO, AssetUnit.BTC);
//         assetRepository.save(asset);

//         Optional<AssetEntity> result = assetRepository.findBySymbol("BTC");

//         assertTrue(result.isPresent());
//         assertEquals("BTC", result.get().getSymbol());
//     }
// }

