package com.ncTestService.services.impl;

import com.ncTestService.models.Role;
import com.ncTestService.repositories.RoleRepository;
import com.ncTestService.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRole(String name) {
        return roleRepository.findByName(name);
    }
}
