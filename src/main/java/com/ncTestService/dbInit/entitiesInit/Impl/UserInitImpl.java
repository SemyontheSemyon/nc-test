package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.UserInit;
import com.ncTestService.models.Role;
import com.ncTestService.models.User;
import com.ncTestService.repositories.RoleRepository;
import com.ncTestService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void initUsers() {

        List<User> list = new ArrayList<>();

        User userNAP = new User();
        userNAP.setLogin("NAP");
        userNAP.setPassword("NAP");
        userNAP.setRoles(new HashSet<>());
        userNAP.getRoles().add(roleRepository.findByName("NAP"));

        User userPAP = new User();
        userPAP.setLogin("PAP");
        userPAP.setPassword("PAP");
        userPAP.setRoles(new HashSet<>());
        userPAP.getRoles().add(roleRepository.findByName("PAP"));

        User userHR = new User();
        userHR.setLogin("HR");
        userHR.setPassword("HR");
        userHR.setRoles(new HashSet<>());
        userHR.getRoles().add(roleRepository.findByName("HR"));

        User userHRPlus = new User();
        userHRPlus.setLogin("HRPlus");
        userHRPlus.setPassword("HRPlus");
        userHRPlus.setRoles(new HashSet<>());
        userHRPlus.getRoles().add(roleRepository.findByName("HR_PLUS"));
        userHRPlus.getRoles().add(roleRepository.findByName("HR"));

        list.add(userHR);
        list.add(userHRPlus);
        list.add(userNAP);
        list.add(userPAP);

        userRepository.saveAll(list);



    }
}
