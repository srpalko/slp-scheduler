package org.steve.palko.slps.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.data.PatientRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/patient-management")
@SessionAttributes("patient")
@Slf4j
public class PatientManagementController {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientManagementController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @ModelAttribute
    public void addPatientsToModel(Model model) {
        Iterable<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
    }

    @GetMapping
    public String showPatientView() {
        return "patientManagement";
    }

    @GetMapping("/new-patient")
    public String showNewPatientForm(Model model) {
        model.addAttribute("newPatient", new Patient());
        return "newPatientForm";
    }

    @GetMapping("/edit")
    public String showEditView(Model model, String patientId) {
        var patient = patientRepository.getById(Long.parseLong(patientId));
        model.addAttribute("patient", patient);
        return "editPatient";
    }

    @PostMapping
    public String processNewPatient(@Valid @ModelAttribute("newPatient") Patient patient, Errors errors) {
        if (errors.hasErrors()) {
            return "newPatientForm";
        }

        patientRepository.save(patient);
        log.info("Patient processed successfully");
        return "redirect:/patient-management";
    }

    @PostMapping("/delete")
    public String deletePatient(String patientId) {
        patientRepository.deleteById(Long.parseLong(patientId));
        return "redirect:/patient-management";
    }

    @PostMapping("/update")
    public String updatePatient(@Valid @ModelAttribute("patient") Patient patient, Errors errors) {
        if (errors.hasErrors()) {
            return "editPatient";
        }
        var updatePatient = patientRepository.getById(patient.getId());
        if (patient.getFirstName() != null) {
            updatePatient.setFirstName(patient.getFirstName());
        }
        if (patient.getLastName() != null) {
            updatePatient.setLastName(patient.getLastName());
        }
        if (patient.getSsn() != null) {
            updatePatient.setSsn(patient.getSsn());
        }
        if (patient.getDateOfBirth() != null) {
            updatePatient.setDateOfBirth(patient.getDateOfBirth());
        }
        if (patient.getAddress().getStreetAddress() != null) {
            updatePatient.getAddress().setStreetAddress(patient.getAddress().getStreetAddress());
        }
        if (patient.getAddress().getCity() != null) {
            updatePatient.getAddress().setCity(patient.getAddress().getCity());
        }
        if (patient.getAddress().getState() != null) {
            updatePatient.getAddress().setState(patient.getAddress().getState());
        }
        if (patient.getAddress().getZip() != null) {
            updatePatient.getAddress().setZip(patient.getAddress().getZip());
        }
        updatePatient.setStatus(patient.getStatus());
        patientRepository.save(updatePatient);
        return "redirect:/patient-management";
    }
}
