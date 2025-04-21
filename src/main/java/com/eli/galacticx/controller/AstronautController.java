package com.eli.galacticx.controller;

import com.eli.galacticx.dto.AstronautRequestDTO;
import com.eli.galacticx.dto.AstronautResponseDTO;
import com.eli.galacticx.service.AstronautService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;

    @PostMapping
    public ResponseEntity<AstronautResponseDTO> createAstronaut(
            @Valid @RequestBody AstronautRequestDTO request) {

        AstronautResponseDTO response = astronautService.createAstronaut(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDTO>> getAllAstronauts(
            @RequestParam(defaultValue = "experienceYears") String sort,
            @RequestParam(defaultValue = "asc") String order) {

        List<AstronautResponseDTO> response = astronautService.getAllSorted(sort, order);
        return ResponseEntity.ok(response);
    }
}
