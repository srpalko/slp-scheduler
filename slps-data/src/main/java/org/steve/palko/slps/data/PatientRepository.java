package org.steve.palko.slps.data;

import org.springframework.data.repository.CrudRepository;
import org.steve.palko.slps.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
