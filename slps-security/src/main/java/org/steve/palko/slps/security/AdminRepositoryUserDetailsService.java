package org.steve.palko.slps.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.steve.palko.slps.data.AdminRepository;

@Service
public class AdminRepositoryUserDetailsService implements UserDetailsService {
    private final AdminRepository adminRepository;

    public AdminRepositoryUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var admin = adminRepository.findByUsername(s);
        if (admin != null) {
            return admin;
        }
        throw new UsernameNotFoundException("Administrator '" + s + "' not found");
    }
}
