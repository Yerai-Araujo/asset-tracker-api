package com.at.asset_tracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.at.asset_tracker.application.dto.request.CreateAssetRequest;
import com.at.asset_tracker.application.dto.response.AssetResponse;
import com.at.asset_tracker.application.mapper.AssetMapper;
import com.at.asset_tracker.application.service.AssetService;
import com.at.asset_tracker.domain.model.Asset;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;
    private final AssetMapper assetMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssetResponse create(@Valid @RequestBody CreateAssetRequest request) {

        Asset asset = assetService.createAsset(
                request.symbol(),
                request.type(),
                request.unit()
        );

        return assetMapper.toResponse(asset);
    }

    @GetMapping
    public List<AssetResponse> findAll() {
        return assetService.getAllAssets()
                .stream()
                .map(assetMapper::toResponse)
                .toList();
    }
}
