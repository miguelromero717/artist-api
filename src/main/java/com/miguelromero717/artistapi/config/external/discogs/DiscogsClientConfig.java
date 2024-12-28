package com.miguelromero717.artistapi.config.external.discogs;

import com.miguelromero717.artistapi.external.discogs.DiscogsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class DiscogsClientConfig {

    @Value("${discogs.api.url}")
    private String apiUrl;

    @Bean
    public DiscogsClient discogsClient() {
        RestClient restClient = RestClient.create(apiUrl);
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return factory.createClient(DiscogsClient.class);
    }
}
