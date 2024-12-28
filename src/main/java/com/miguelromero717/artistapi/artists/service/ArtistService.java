package com.miguelromero717.artistapi.artists.service;

import com.miguelromero717.artistapi.artists.dto.SearchArtistResponseDTO;
import com.miguelromero717.artistapi.config.external.discogs.DiscogsKeys;
import com.miguelromero717.artistapi.exceptions.ArtistNotFoundException;
import com.miguelromero717.artistapi.external.discogs.DiscogsClient;
import com.miguelromero717.artistapi.external.discogs.dto.SearchResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService implements IArtistsService {

    private final DiscogsClient discogsClient;
    private final DiscogsKeys discogsKeys;

    public ArtistService(DiscogsClient discogsClient, DiscogsKeys discogsKeys) {
        this.discogsClient = discogsClient;
        this.discogsKeys = discogsKeys;
    }

    @Override
    public List<SearchArtistResponseDTO> searchArtist(String artistName) throws ArtistNotFoundException {
        SearchResponseDTO searchResponseDTO = discogsClient.searchArtists(
                artistName,
                discogsKeys.consumerKey(),
                discogsKeys.consumerSecret()
        );

        if (searchResponseDTO.results().isEmpty()) {
            throw new ArtistNotFoundException(String.format("Artist %s not found", artistName));
        }

        return searchResponseDTO.results()
                .stream()
                .map(result -> new SearchArtistResponseDTO(result.id(), result.title()))
                .toList();
    }
}
