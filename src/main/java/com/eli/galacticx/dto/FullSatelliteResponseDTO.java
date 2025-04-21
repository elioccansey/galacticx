package com.eli.galacticx.dto;

import java.time.LocalDate;
import java.util.Set;

public record FullSatelliteResponseDTO(
        Long id,
        String name,
        LocalDate launchDate,
        String orbitType,
        boolean decommissioned,
        Set<AstronautBasicDTO> astronauts
) {}
