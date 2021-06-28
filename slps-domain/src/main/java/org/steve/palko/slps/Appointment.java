package org.steve.palko.slps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Embeddable
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
}
