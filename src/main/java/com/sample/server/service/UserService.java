package com.sample.server.service;

import com.sample.server.model.Login;
import com.sample.server.model.User;
import com.sample.server.repository.UserRepository;
import com.sample.server.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public Optional<User> getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByName(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public String login(Login login) {
        final Optional<User> byName = getByName(login.getUsername());
        if (byName.isPresent()) {
            User currentUser = byName.get();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

            return JwtTokenProvider.TOKEN_PREFIX + JwtTokenProvider.createToken(currentUser.getUsername());
        }
        return null;
    }
}