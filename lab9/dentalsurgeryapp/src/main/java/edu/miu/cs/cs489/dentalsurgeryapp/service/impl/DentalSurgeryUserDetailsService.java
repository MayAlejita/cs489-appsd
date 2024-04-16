package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DentalSurgeryUserDetailsService implements UserDetailsService {
    private UserRepository userRepo;
    public DentalSurgeryUserDetailsService(UserRepository userRepo) {this.userRepo = userRepo;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found for:" + username));
    }
}
