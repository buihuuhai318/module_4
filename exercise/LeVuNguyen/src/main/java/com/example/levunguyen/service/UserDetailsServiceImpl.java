package com.example.levunguyen.service;

import com.example.levunguyen.model.AppUser;
import com.example.levunguyen.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.getAppUserByUsernameContaining(username);
        if (appUser == null) {
            System.out.println("user not found!!! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);

        String roleName = appUser.getRole().getName();
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
        grantList.add(grantedAuthority);
        UserDetails userDetails = new User(appUser.getUsername(), appUser.getPassword(), grantList);
        return userDetails;
    }
}
