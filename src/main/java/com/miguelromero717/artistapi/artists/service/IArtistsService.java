package com.miguelromero717.artistapi.artists.service;

import com.miguelromero717.artistapi.artists.dto.SearchArtistResponseDTO;
import com.miguelromero717.artistapi.exceptions.ArtistNotFoundException;

import java.util.List;

public interface IArtistsService {

    List<SearchArtistResponseDTO> searchArtist(String artistName) throws ArtistNotFoundException;
}
