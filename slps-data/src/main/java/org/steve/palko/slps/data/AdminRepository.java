package org.steve.palko.slps.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.steve.palko.slps.Administrator;

public interface AdminRepository extends JpaRepository<Administrator, Long> {
    public Administrator findByUsername(String username);
}
