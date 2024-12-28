package com.miguelromero717.artistapi.config.external.discogs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record DiscogsKeys(
        @Value("${discogs.consumer.key}")
        String consumerKey,

        @Value("${discogs.consumer.secret}")
        String consumerSecret
) {
}
