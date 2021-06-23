package org.steve.palko.slps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.steve.palko.slps.data.AdminRepository;
import org.steve.palko.slps.data.PatientRepository;
import org.steve.palko.slps.data.TherapistRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Configuration
@Slf4j
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(PatientRepository patientRepository, TherapistRepository therapistRepository,
                                        AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            patientRepository.save(new Patient("James", "Jamerson",
                    new GregorianCalendar(1980, Calendar.APRIL, 2), "555-78-9874",
                    new Address("1240 Old Concord Rd", "Monroeville", "PA",
                            "15146")));
            patientRepository.save(new Patient("Stanley", "Clarke",
                    new GregorianCalendar(1962, Calendar.APRIL, 12), "122-45-9663",
                    new Address("135 Shirehill Dr", "Glenshaw", "PA", "15116")));
            var priorityPatient = new Patient("Jaco", "Pastorius",
                    new GregorianCalendar(1964, Calendar.MAY, 23), "457-88-8741",
                    new Address("824 Isobel St", "Harwick", "PA", "15049"));
            priorityPatient.setStatus(Patient.PatientStatus.PRIORITY);
            patientRepository.save(priorityPatient);

            var testTherapist = new Therapist("wackyzoo", passwordEncoder.encode("mambo"),
                    "Elizabeth", "Byrne", "412-877-2577", "byrne@gmail.com",
                    new Address("3128 Harts Run Rd", "Allison Park", "PA", "15101"));
            var testPatient = new Patient("Frank", "Zappa",
                    new GregorianCalendar(1978, Calendar.JANUARY, 20), "465-89-8774",
                    new Address("3128 Harts Run Rd", "Allison Park", "PA",
                            "15101"));
            patientRepository.save(testPatient);
            therapistRepository.save(testTherapist);

            adminRepository.save(new Administrator("Debby", "Buckles", "buckles",
                    passwordEncoder.encode("buck")));
        };
    }
}
