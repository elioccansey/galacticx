package com.eli.galacticx.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record SatelliteRequestDTO(
        @NotBlank(message = "Satellite name must not be blank")
        String name,

        @Past(message = "Launch date must be a past date")
        LocalDate launchDate,

        @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO")
        String orbitType,

        boolean decommissioned
) {}
