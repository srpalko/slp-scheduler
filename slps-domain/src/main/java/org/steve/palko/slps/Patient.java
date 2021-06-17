package org.steve.palko.slps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private String ssn;

    @Embedded
    private Address address;

    @Embedded
    private Location location;

    public Patient(String firstName, String lastName, Calendar dateOfBirth, String ssn, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.address = address;
        this.location = new LocationFinder().findLocation(address);
    }
}
