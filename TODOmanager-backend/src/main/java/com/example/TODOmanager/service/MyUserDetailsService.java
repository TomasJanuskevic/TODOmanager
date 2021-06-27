package com.example.TODOmanager.service;

import com.example.TODOmanager.model.User;
import com.example.TODOmanager.model.UserPrincipal;
import com.example.TODOmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user =  userRepository.findByName(name);

        if(user == null){
            throw new UsernameNotFoundException("user by name " + name + ", was not found");
        }

        return  new UserPrincipal(user);
    }
}
