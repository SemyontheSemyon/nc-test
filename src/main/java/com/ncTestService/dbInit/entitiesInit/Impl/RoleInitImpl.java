package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.RoleInit;
import com.ncTestService.models.Role;
import com.ncTestService.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleInitImpl implements RoleInit {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void initRoles() {

        List<Role> list = new ArrayList<>();

        String[] roles = {"ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN"};

        for(String role : roles) {
            list.add(new Role(role));
        }

        roleRepository.saveAll(list);

    }
}
