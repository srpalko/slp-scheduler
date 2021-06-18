package org.steve.palko.slps;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Patient implements Serializable {
    private static final long SERIAL_VERSION_UUID = 98768697L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private String ssn;
    private Date startOfCare;
    private PatientStatus status = PatientStatus.REGULAR;

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

    @PrePersist
    public void setStartOfCare() {
        this.startOfCare = new Date();
    }

    public enum PatientStatus {
        REGULAR, PRIORITY
    }
}
