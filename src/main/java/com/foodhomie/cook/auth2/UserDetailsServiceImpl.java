package com.foodhomie.cook.auth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<ApplicationUser> users = Arrays.asList(
                new ApplicationUser("omar",encoder.encode("12345"), "USER"),
                new ApplicationUser("admin", encoder.encode("12345"), "ADMIN")
        );

        for(ApplicationUser appUser: users) {
            if(appUser.getUsername().equals(username)) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList( appUser.getRole());

                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");

    }
}