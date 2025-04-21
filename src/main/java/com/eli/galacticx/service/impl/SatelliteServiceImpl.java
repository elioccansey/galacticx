package com.eli.galacticx.service.impl;

import com.eli.galacticx.dto.SatelliteRequestDTO;
import com.eli.galacticx.dto.SatelliteResponseDTO;
import com.eli.galacticx.exception.SatelliteNotFoundException;
import com.eli.galacticx.model.Satellite;
import com.eli.galacticx.repository.SatelliteRepository;
import com.eli.galacticx.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepository;

    @Override
    public SatelliteResponseDTO updateSatellite(Long id, SatelliteRequestDTO request) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));

        if (satellite.isDecommissioned()) {
            throw new IllegalStateException("Cannot update decommissioned satellite.");
        }

        satellite.setName(request.name());
        satellite.setLaunchDate(request.launchDate());
        satellite.setOrbitType(request.orbitType());
        satellite.setDecommissioned(request.decommissioned());

        Satellite updated = satelliteRepository.save(satellite);

        return new SatelliteResponseDTO(updated.getId(), updated.getName(), updated.getLaunchDate(), updated.getOrbitType(), updated.isDecommissioned());
    }
}
