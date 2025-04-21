package com.eli.galacticx.dto;

import java.util.Set;

public record AstronautResponseDTO(
        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        Set<SatelliteResponseDTO> satellites
) {}
