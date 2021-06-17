package org.steve.palko.slps;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Appointment {
    private Patient patient;
    private Therapist therapist;
    private Date appointmentTime;
    private VisitType visitType;

    public enum VisitType {
        EVAL, REGULAR
    }
}
