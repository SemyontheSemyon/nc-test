package com.ncTestService.security;

import com.ncTestService.models.Role;
import com.ncTestService.models.User;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.getUser(s);
        if(user == null) {
            throw  new UsernameNotFoundException(s);
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthorities(user));

    }

    private static Set<GrantedAuthority> getAuthorities(User user) {

        Set<GrantedAuthority> authoritySet = new HashSet<>();

        for(Role role : user.getRoles()) {
            authoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authoritySet;

    }
}
