package com.eli.galacticx.dto;

import jakarta.validation.constraints.*;
import java.util.Set;

public record AstronautRequestDTO(
        @NotBlank(message = "First name must not be blank")
        @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
        String firstName,

        @NotBlank(message = "Last name must not be blank")
        @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
        String lastName,

        @Min(value = 0, message = "Experience must be at least 0 years")
        @Max(value = 50, message = "Experience must not exceed 50 years")
        int experienceYears,

        @NotNull(message = "Satellite IDs must be provided")
        Set<Long> satelliteIds
) {}
