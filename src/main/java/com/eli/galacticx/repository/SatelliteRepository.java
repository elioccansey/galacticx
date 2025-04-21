package com.eli.galacticx.repository;

import com.eli.galacticx.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    Optional<Satellite> findByName(String name);
}
