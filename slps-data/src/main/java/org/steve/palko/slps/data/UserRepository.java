package org.steve.palko.slps.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.steve.palko.slps.Therapist;

public interface UserRepository extends CrudRepository<Therapist, Long> {
    Therapist findByUsername(String username);
}
