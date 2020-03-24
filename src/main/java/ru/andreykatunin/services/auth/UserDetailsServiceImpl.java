package ru.andreykatunin.services.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Users;
import ru.andreykatunin.services.item.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService service;

    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("CHECK user " + username);
        if (username.equals(""))
            throw new UsernameNotFoundException("User not found");
        Users user = service.getUser(username);
        if (user == null) {
            System.out.println("NOT FOUND user " + username);
            throw new UsernameNotFoundException("User not found");
        } else {
            System.out.println("FOUND user " + username);
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority(String.valueOf(user.getRoleId()));
            grantedAuthorityList.add(authority);
            return new User(username, new BCryptPasswordEncoder().encode(user.getPassword()), grantedAuthorityList);
        }

    }
}
