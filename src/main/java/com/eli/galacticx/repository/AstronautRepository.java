package com.eli.galacticx.repository;

import com.eli.galacticx.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
