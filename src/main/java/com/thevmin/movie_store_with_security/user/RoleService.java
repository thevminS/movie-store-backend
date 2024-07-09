package com.thevmin.movie_store_with_security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public Optional<Role> getUser(){
        return roleRepository.findByName("USER");
    }

    public Optional<Role> getAdmin(){
        return roleRepository.findByName("ADMIN");
    }
}
