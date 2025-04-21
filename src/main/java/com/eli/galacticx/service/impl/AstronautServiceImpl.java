package com.eli.galacticx.service.impl;

import com.eli.galacticx.dto.*;
import com.eli.galacticx.exception.*;
import com.eli.galacticx.model.*;
import com.eli.galacticx.repository.*;
import com.eli.galacticx.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    @Override
    public AstronautResponseDTO createAstronaut(AstronautRequestDTO request) {
        // Validate satellite IDs
        Set<Satellite> satellites = request.satelliteIds().stream()
                .map(id -> satelliteRepository.findById(id)
                        .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found")))
                .collect(Collectors.toSet());

        // Build and save entity
        Astronaut astronaut = Astronaut.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .experienceYears(request.experienceYears())
                .satellites(satellites)
                .build();

        astronaut = astronautRepository.save(astronaut);

        return mapToResponseDTO(astronaut);
    }

    @Override
    public List<AstronautResponseDTO> getAllSorted(String sortField, String order) {
        Sort.Direction direction = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<Astronaut> astronauts = astronautRepository.findAll(Sort.by(direction, sortField));
        return astronauts.stream().map(this::mapToResponseDTO).toList();
    }

    private AstronautResponseDTO mapToResponseDTO(Astronaut astronaut) {
        Set<SatelliteResponseDTO> satelliteDTOs = astronaut.getSatellites().stream()
                .map(sat -> new SatelliteResponseDTO(sat.getId(), sat.getName(), sat.getLaunchDate(), sat.getOrbitType(), sat.isDecommissioned()))
                .collect(Collectors.toSet());

        return new AstronautResponseDTO(
                astronaut.getId(),
                astronaut.getFirstName(),
                astronaut.getLastName(),
                astronaut.getExperienceYears(),
                satelliteDTOs
        );
    }
}
