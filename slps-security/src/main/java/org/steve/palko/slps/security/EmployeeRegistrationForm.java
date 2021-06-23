package org.steve.palko.slps.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.steve.palko.slps.Address;
import org.steve.palko.slps.Therapist;

@Data
public class EmployeeRegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    public Therapist toTherapist(PasswordEncoder passwordEncoder) {
        return new Therapist(username, passwordEncoder.encode(password), firstName, lastName, phoneNumber, email,
                new Address(streetAddress, city, state, zip));
    }
}
