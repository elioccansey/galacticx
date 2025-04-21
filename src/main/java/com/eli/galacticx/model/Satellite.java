package com.eli.galacticx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Satellite name must not be blank")
    @Column(unique = true)
    private String name;

    @Past(message = "Launch date must be a past date")
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;

    private boolean decommissioned;

    public boolean isDecommissioned() {
        return decommissioned;
    }
}
