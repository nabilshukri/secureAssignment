package com.example.secureAssignment.services;

import com.example.secureAssignment.models.ApplicationUser;
import com.example.secureAssignment.models.Role;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Insied the user details");

        if(!username.equals("Amir")) throw new UsernameNotFoundException("It's not Amir");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER",1));

        return new ApplicationUser(1, "amir", encoder.encode("password"), roles );
    }
}
