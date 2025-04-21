package com.eli.galacticx.service;

import com.eli.galacticx.dto.SatelliteRequestDTO;
import com.eli.galacticx.dto.SatelliteResponseDTO;

public interface SatelliteService {
    SatelliteResponseDTO updateSatellite(Long id, SatelliteRequestDTO request);
}
