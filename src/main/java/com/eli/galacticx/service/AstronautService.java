package com.eli.galacticx.service;

import com.eli.galacticx.dto.AstronautRequestDTO;
import com.eli.galacticx.dto.AstronautResponseDTO;

import java.util.List;

public interface AstronautService {
    AstronautResponseDTO createAstronaut(AstronautRequestDTO request);
    List<AstronautResponseDTO> getAllSorted(String sortField, String order);
}
