package org.steve.palko.slps.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.data.PatientRepository;

@RestController
@RequestMapping(path = "/patient", produces = "application/json")
@CrossOrigin(origins = "*")
public class PatientTestController {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientTestController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping()
    public Iterable<Patient> patients() {
        return patientRepository.findAll();
    }
}
