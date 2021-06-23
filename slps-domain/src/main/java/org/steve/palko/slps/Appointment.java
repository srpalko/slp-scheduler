package org.steve.palko.slps;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Appointment implements Serializable {
    private static final long serialVersionUID = 987456L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NotNull
    private Patient patient;

    @OneToOne
    @NotNull
    private Therapist therapist;

    @NotNull
    private VisitDay appointmentDay;

    public enum VisitDay {
        M, T, W, R, F
    }
}
