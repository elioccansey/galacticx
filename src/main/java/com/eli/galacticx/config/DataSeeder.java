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
                Satellite s1 = satelliteRepo.save(new Satellite(null, "Hubble", LocalDate.of(1990, 4, 24), "LEO", false));
                Satellite s2 = satelliteRepo.save(new Satellite(null, "Starlink-17", LocalDate.of(2023, 8, 14), "MEO", false));
                Satellite s3 = satelliteRepo.save(new Satellite(null, "Sentinel-6", LocalDate.of(2020, 11, 21), "LEO", true));

                astronautRepo.save(Astronaut.builder()
                        .firstName("Neil")
                        .lastName("Armstrong")
                        .experienceYears(12)
                        .satellites(Set.of(s1, s2))
                        .build());

                astronautRepo.save(Astronaut.builder()
                        .firstName("Sally")
                        .lastName("Ride")
                        .experienceYears(8)
                        .satellites(Set.of(s2))
                        .build());

                astronautRepo.save(Astronaut.builder()
                        .firstName("Chris")
                        .lastName("Hadfield")
                        .experienceYears(15)
                        .satellites(Set.of(s1, s3))
                        .build());
            }
        };
    }
}
