package org.steve.palko.slps.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.steve.palko.slps.Therapist;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
    Therapist findByUsername(String username);
}
