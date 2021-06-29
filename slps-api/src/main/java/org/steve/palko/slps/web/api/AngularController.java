package org.steve.palko.slps.web.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.steve.palko.slps.Location;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.Schedule;
import org.steve.palko.slps.Therapist;
import org.steve.palko.slps.data.PatientRepository;
import org.steve.palko.slps.data.TherapistRepository;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/patient", produces = "application/json")
@CrossOrigin(origins = "*")
@Slf4j
public class AngularController {
    private final PatientRepository patientRepository;
    private final TherapistRepository therapistRepository;

    @Autowired
    public AngularController(PatientRepository patientRepository, TherapistRepository therapistRepository) {
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

    @GetMapping("/getTherapist/{therapistId}")
    public Therapist getTherapistById(@PathVariable("therapistId") Long id) {
        return therapistRepository.getById(id);
    }


    @GetMapping("/getSchedule/{therapistId}")
    public Schedule getTherapistSchedule(@PathVariable("therapistId") Long id) {
        return therapistRepository.getById(id).getSchedule();
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

    @PutMapping(path = "/addSchedule/{therapistId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin(origins = "*")
    public Schedule addSchedule(@PathVariable("therapistId") Long therapistId, @RequestBody Schedule schedule) {
        var therapist = therapistRepository.getById(therapistId);
        therapist.setSchedule(schedule);
        therapist = therapistRepository.save(therapist);
        return therapist.getSchedule();
    }
}
