package com.miguelromero717.artistapi.external.discogs.dto;

import java.util.List;

public record SearchResponseDTO(
        List<SearchResultDTO> results
) {
}
