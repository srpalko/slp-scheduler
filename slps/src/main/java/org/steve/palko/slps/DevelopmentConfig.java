package org.steve.palko.slps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.steve.palko.slps.data.PatientRepository;

import java.util.GregorianCalendar;

@Configuration
@Slf4j
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(PatientRepository repo) {
        return args -> {
            repo.save(new Patient("Frank", "Zappa",
                    new GregorianCalendar(1978, 0, 20), "465-89-8774",
                    new Address("3128 Harts Run Rd", "Allison Park", "PA",
                            "15101")));
            repo.save(new Patient("James", "Jamerson",
                    new GregorianCalendar(1980, 3, 2), "555-78-9874",
                    new Address("1240 Old Concord Rd", "Monroeville", "PA",
                            "15146")));
            repo.save(new Patient("Stanley", "Clarke",
                    new GregorianCalendar(1962, 3, 12), "122-45-9663",
                    new Address("135 Shirehill Dr", "Glenshaw", "PA", "15116")));
            Patient priorityPatient = new Patient("Jaco", "Pastorius",
                    new GregorianCalendar(1964, 4, 23), "457-88-8741",
                    new Address("824 Isobel St", "Harwick", "PA", "15049"));
            priorityPatient.setStatus(Patient.PatientStatus.PRIORITY);
            repo.save(priorityPatient);
        };
    }
}
