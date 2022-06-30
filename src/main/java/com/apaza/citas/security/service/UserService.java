package com.apaza.citas.security.service;

import com.apaza.citas.security.jwt.JwtProvider;
import com.apaza.citas.security.model.RoleUser;
import com.apaza.citas.security.model.Users;
import com.apaza.citas.security.model.UserDetail;
import com.apaza.citas.security.model.dto.JwtDto;
import com.apaza.citas.security.model.dto.LoginDto;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.repository.RoleUserRepository;
import com.apaza.citas.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleUserRepository roleUserRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = getByUsername(username);
        return UserDetail.build(users);
    }

    public List<Users> getAll(){
        return (List<Users>) repository.findAll();
    }

    public Users getByUsername(String Username){
        return repository.findByUsername(Username);
    }

    public boolean existsByUsername(String username){
        return repository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return repository.existsByEmail(email);
    }

    public void create(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        repository.save(users);
    }

    public String newUser(UserDto userDto){
        Users users = new Users();
        Set<RoleUser> roles = new HashSet<>();
        RoleUser role = roleUserRepository.findByName(userDto.getRol());
        role.setId(role.getId());
        roles.add(role);

        users.setNames(userDto.getNames());
        users.setSurnames(userDto.getSurnames());
        users.setEmail(userDto.getEmail());
        users.setUsername(userDto.getUsername());
        users.setPassword(userDto.getPassword());
        users.setRoles(roles);

        this.create(users);
        return "Users \""+ users.getUsername()+"\" Created.";
    }

    public JwtDto Login(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new JwtDto(token);
    }

    public JwtDto refresh(JwtDto jwtDto){
        String token = jwtProvider.refreshToken(jwtDto);
        return new JwtDto(token);
    }
}
