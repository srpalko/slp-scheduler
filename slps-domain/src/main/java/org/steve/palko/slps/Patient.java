package org.steve.palko.slps;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 98768697L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Name cannot be blank")
    private String lastName;

    @NotNull(message = "Date of birth cannot be blank")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    private Calendar dateOfBirth;

    @NotBlank(message = "Social Security cannot be blank")
    private String ssn;
    private Date startOfCare;
    private PatientStatus status = PatientStatus.REGULAR;

    private boolean assigned = false;

    @Embedded
    @NotNull
    private Address address = new Address();

    @Embedded
    private Location location;

    public Patient(String firstName, String lastName, Calendar dateOfBirth, String ssn, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.address = address;
    }

    @PrePersist
    public void setStartOfCare() {
        this.startOfCare = new Date();
        this.location = new LocationFinder().findLocation(address);
    }

    public String getDateOfBirthAsString() {
        var format = new SimpleDateFormat("MM-dd-yyyy");
        format.setCalendar(dateOfBirth);
        return format.format(dateOfBirth.getTime());
    }

    public String getDateOfBirthAsHtmlInputString() {
        var format = new SimpleDateFormat("yyyy-MM-dd");
        format.setCalendar(dateOfBirth);
        return format.format(dateOfBirth.getTime());
    }

    public static enum PatientStatus {
        REGULAR, PRIORITY
    }
}
