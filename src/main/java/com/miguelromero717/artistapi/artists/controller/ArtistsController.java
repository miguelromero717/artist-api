package com.miguelromero717.artistapi.artists.controller;

import com.miguelromero717.artistapi.artists.dto.SearchArtistResponseDTO;
import com.miguelromero717.artistapi.artists.service.IArtistsService;
import com.miguelromero717.artistapi.exceptions.ArtistNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/artists")
public class ArtistsController {

    private final IArtistsService artistsService;

    public ArtistsController(IArtistsService artistsService) {
        this.artistsService = artistsService;
    }

    @GetMapping
    public ResponseEntity<List<SearchArtistResponseDTO>> searchArtist(
            @RequestParam
            String artistName
    ) throws ArtistNotFoundException {
        return ResponseEntity.ok(artistsService.searchArtist(artistName));
    }
}
