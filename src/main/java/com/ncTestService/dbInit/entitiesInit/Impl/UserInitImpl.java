package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.UserInit;
import com.ncTestService.models.User;
import com.ncTestService.repositories.RoleRepository;
import com.ncTestService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class UserInitImpl implements UserInit {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    private final int NUMBER_OF_USERS = 150;

    @Override
    public void initUsers() {

        List<User> list = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            User userNAP = new User();
            userNAP.setEmail("USER" + i);
            userNAP.setPassword(encoder.encode("123456"));
            userNAP.setRoles(new HashSet<>());
            userNAP.getRoles().add(roleRepository.findByName("ROLE_USER"));
            list.add(userNAP);
        }

        User userPAP = new User();
        userPAP.setEmail("HR");
        userPAP.setPassword(encoder.encode("123456"));
        userPAP.setRoles(new HashSet<>());
        userPAP.getRoles().add(roleRepository.findByName("ROLE_MANAGER"));

        list.add(userPAP);

        userRepository.saveAll(list);

    }
}
