package com.eli.galacticx.dto;

import java.time.LocalDate;

public record SatelliteResponseDTO(
        Long id,
        String name,
        LocalDate launchDate,
        String orbitType,
        boolean decommissioned
) {}
