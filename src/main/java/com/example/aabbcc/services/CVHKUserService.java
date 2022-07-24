package com.example.aabbcc.services;

import com.example.aabbcc.model.Role;
import com.example.aabbcc.model.User;
import com.example.aabbcc.repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CVHKUserService implements UserDetailsService {

    private final UserRepo userRepo;

    public CVHKUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("invalid email");

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());

    }

}