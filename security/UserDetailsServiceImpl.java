package com.implementingspringsecuritywithauthentication.security;

import com.implementingspringsecuritywithauthentication.domain.*;
import com.implementingspringsecuritywithauthentication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Username not found!: "+ userName));
        return user.map(UserDetailsImpl::new).get();
    }

}
