package org.steve.palko.slps.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.data.PatientRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/patient-management")
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
        return "redirect:/";
    }
}
