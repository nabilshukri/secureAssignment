package com.example.secureAssignment.services;

import com.example.secureAssignment.models.ApplicationUser;
import com.example.secureAssignment.models.Role;
import com.example.secureAssignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Insied the user details");

//        if(!username.equals("Amir")) throw new UsernameNotFoundException("It's not Amir");
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1,"USER"));
//        return new ApplicationUser(1, "amir", encoder.encode("password"), roles );

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User is not valid"));
    }
}
