package com.eli.galacticx.controller;

import com.eli.galacticx.dto.SatelliteRequestDTO;
import com.eli.galacticx.dto.SatelliteResponseDTO;
import com.eli.galacticx.service.SatelliteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDTO> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDTO request) {

        SatelliteResponseDTO response = satelliteService.updateSatellite(id, request);
        return ResponseEntity.ok(response);
    }
}
