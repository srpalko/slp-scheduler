package org.steve.palko.slps.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.steve.palko.slps.Patient;
import org.steve.palko.slps.Therapist;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RepositoryRestResource
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findAllByAssignedFalse();
}
