package com.eli.galacticx.config;

import com.eli.galacticx.model.Astronaut;
import com.eli.galacticx.model.Satellite;
import com.eli.galacticx.repository.AstronautRepository;
import com.eli.galacticx.repository.SatelliteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(SatelliteRepository satelliteRepo, AstronautRepository astronautRepo) {
        return args -> {
            if (satelliteRepo.count() == 0 && astronautRepo.count() == 0) {

                // Seed satellites
                Satellite s1 = satelliteRepo.save(
                        Satellite.builder()
                                .name("Hubble")
                                .launchDate(LocalDate.of(1990, 4, 24))
                                .orbitType("LEO")
                                .decommissioned(false)
                                .build());

                Satellite s2 = satelliteRepo.save(
                        Satellite.builder()
                                .name("Starlink-17")
                                .launchDate(LocalDate.of(2023, 8, 14))
                                .orbitType("MEO")
                                .decommissioned(false)
                                .build());

                Satellite s3 = satelliteRepo.save(
                        Satellite.builder()
                                .name("Sentinel-6")
                                .launchDate(LocalDate.of(2020, 11, 21))
                                .orbitType("LEO")
                                .decommissioned(true)
                                .build());

                // Seed astronauts with satellite assignments
                Astronaut a1 = Astronaut.builder()
                        .firstName("Neil")
                        .lastName("Armstrong")
                        .experienceYears(12)
                        .satellites(Set.of(s1, s2))
                        .build();

                Astronaut a2 = Astronaut.builder()
                        .firstName("Sally")
                        .lastName("Ride")
                        .experienceYears(8)
                        .satellites(Set.of(s2))
                        .build();

                Astronaut a3 = Astronaut.builder()
                        .firstName("Chris")
                        .lastName("Hadfield")
                        .experienceYears(15)
                        .satellites(Set.of(s1, s3))
                        .build();

                astronautRepo.saveAll(Set.of(a1, a2, a3));
            }
        };
    }
}
