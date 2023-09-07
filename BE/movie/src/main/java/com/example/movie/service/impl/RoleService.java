package com.example.movie.service.impl;

import com.example.movie.model.Role;
import com.example.movie.repository.IRoleRepository;
import com.example.movie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository repository;
    @Override
    public Role findRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
