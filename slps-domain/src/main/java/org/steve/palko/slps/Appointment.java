package org.steve.palko.slps;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment implements Serializable {
    private static final long SERIAL_VERSION_UID = 987456L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Therapist therapist;
    private Date appointmentTime;
    private VisitType visitType = VisitType.REGULAR;

    @Embedded
    private ClinicalNote clinicalNote;

    public enum VisitType {
        EVAL, REGULAR
    }
}
