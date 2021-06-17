package org.steve.palko.slps;

import lombok.Data;

import java.util.List;

@Data
public class Therapist {
    private List<Appointment> appointmentList;
    private String homeLocation;
}
