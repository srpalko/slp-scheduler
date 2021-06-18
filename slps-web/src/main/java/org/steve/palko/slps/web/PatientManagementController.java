package org.steve.palko.slps.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.data.PatientRepository;

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
        model.addAttribute("regularPatients", patientRepository.findAllByStatus(Patient.PatientStatus.REGULAR));
        model.addAttribute("priorityPatients", patientRepository.findAllByStatus(Patient.PatientStatus.PRIORITY));
    }

    @GetMapping
    public String showPatientView(Model model) {
        return "patientManagement";
    }

    @GetMapping("/new-patient")
    public String showNewPatientForm(Model model) {
        model.addAttribute("newPatient", new Patient());
        return "newPatientForm";
    }

    @PostMapping
    public String processNewPatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/";
    }
}
