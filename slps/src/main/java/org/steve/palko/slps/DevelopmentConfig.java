package org.steve.palko.slps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.steve.palko.slps.data.PatientRepository;

import java.util.GregorianCalendar;

@Profile("!prod")
@Configuration
@Slf4j
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(PatientRepository repo) {
        return args -> {
            repo.save(new Patient("Steve", "Palko",
                    new GregorianCalendar(1978, 0, 20), "194-60-2152",
                    new Address("3128 Harts Run Rd", "Allison Park", "PA",
                            "15101")));
            repo.save(new Patient("James", "Jamerson",
                    new GregorianCalendar(1980, 3, 2), "555-78-9874",
                    new Address("1240 Old Concord Rd", "Monroeville", "PA",
                            "15146")));
        };
    }
}
