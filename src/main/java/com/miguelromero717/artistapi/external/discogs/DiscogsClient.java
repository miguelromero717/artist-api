package com.miguelromero717.artistapi.external.discogs;


import com.miguelromero717.artistapi.external.discogs.dto.SearchResponseDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface DiscogsClient {

    @GetExchange("/database/search")
    SearchResponseDTO searchArtists(
            @RequestParam("query") String query,
            @RequestParam("key") String key,
            @RequestParam("secret") String secret
    );
}
