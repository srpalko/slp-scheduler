package org.steve.palko.slps;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Therapist implements UserDetails, Serializable {
    private static final long serialVersionUID = 1545645464L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Embedded
    private Schedule schedule = new Schedule();

    @OneToMany
    @ToString.Exclude
    private List<Patient> patients = new ArrayList<>();

    private String homeLocation;

    @NonNull
    @NotBlank(message = "username cannot be blank")
    private String username;

    @NonNull
    @NotBlank(message = "password cannot be blank")
    private String password;

    @NonNull
    @NotBlank(message = "name cannot be blank")
    private String firstName;

    @NonNull
    @NotBlank(message = "name cannot be blank")
    private String lastName;

    @NonNull
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;

    @NonNull
    @NotBlank(message = "email cannot be blank")
    private String email;

    @Embedded
    @NonNull
    private Address address;

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public Appointment generateAppointment(Patient patient) {
        var appt = new Appointment();
        appt.setTherapist(this);
        appt.setPatient(patient);
        return appt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
