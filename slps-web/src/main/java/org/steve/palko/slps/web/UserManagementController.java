package org.steve.palko.slps.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.steve.palko.slps.Therapist;
import org.steve.palko.slps.data.TherapistRepository;
import org.steve.palko.slps.security.EmployeeRegistrationForm;

@Controller
@RequestMapping("/therapist-management")
//@SessionAttributes("therapist")
public class UserManagementController {
    private final TherapistRepository therapistRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManagementController(TherapistRepository therapistRepository, PasswordEncoder passwordEncoder) {
        this.therapistRepository = therapistRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showTherapistView() {
        return "therapistManagement";
    }

    @ModelAttribute
    public void addTherapistsToModel(Model model) {
        Iterable<Therapist> therapists = therapistRepository.findAll();
        model.addAttribute("therapists", therapists);
    }

    @GetMapping("/info")
    public String showInfo(Model model, String therapistId) {
        var therapist = therapistRepository.getById(Long.parseLong(therapistId));
        model.addAttribute("therapist", therapist);
        return "therapistInfo";
    }

    @GetMapping("/add-employee")
    public String showRegistration(Model model) {
        model.addAttribute("employeeRegistrationForm", new EmployeeRegistrationForm());
        return "employeeRegistration";
    }

    @PostMapping
    public String processRegistration(EmployeeRegistrationForm form) {
        therapistRepository.save(form.toTherapist(passwordEncoder));
        return "redirect:/therapist-management";
    }
}
