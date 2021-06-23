package org.steve.palko.slps.web.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.Therapist;
import org.steve.palko.slps.data.PatientRepository;
import org.steve.palko.slps.data.TherapistRepository;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/patient", produces = "application/json")
@CrossOrigin(origins = "*")
@Slf4j
public class PatientTestController {
    private final PatientRepository patientRepository;
    private final TherapistRepository therapistRepository;

    @Autowired
    public PatientTestController(PatientRepository patientRepository, TherapistRepository therapistRepository) {
        this.patientRepository = patientRepository;
        this.therapistRepository = therapistRepository;
    }

    @GetMapping()
    public List<Patient> patients() {
        return patientRepository.findAllByAssignedFalse();
    }

    @GetMapping("/{id}")
    public List<Patient> patientsByTherapistId(@PathVariable("id") Long id) {
        log.info("Getting");
        var therapist = therapistRepository.getById(id);
        List<Patient> patients = therapist.getPatients();
        log.info(patients.toString());
        return patients;
    }

    @PutMapping(path = "/{therapistId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    public Therapist addPatients(@PathVariable("therapistId") Long therapistId,
                                 @RequestBody Collection<Patient> patients) {
        log.info("HERE IN METHOD");
        var therapist = therapistRepository.getById(therapistId);
        patients = patientRepository.saveAll(patients);
        patients.forEach(therapist::addPatient);
        log.info(therapist.getPatients().toString());
        return therapistRepository.save(therapist);
    }
}
