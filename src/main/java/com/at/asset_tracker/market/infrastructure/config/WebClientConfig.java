package com.at.asset_tracker.market.infrastructure.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    @Value("${coinGecko.api.base-url}")
    private String coinGeckoBaseUrl;

    @Value("${metalPrice.api.base-url}")
    private String metalPriceBaseUrl;

    @Bean("coinGeckoWebClient")
    public WebClient coinGeckoWebClient() {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000) // 3s conexión
                .responseTimeout(Duration.ofSeconds(5)); // 5s respuesta

        return WebClient.builder()
                .baseUrl(coinGeckoBaseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean("metalPriceWebClient")
    public WebClient metalPriceWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000) // 3s conexión
                .responseTimeout(Duration.ofSeconds(6)); // 5s respuesta

        return WebClient.builder()
                .baseUrl(metalPriceBaseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
