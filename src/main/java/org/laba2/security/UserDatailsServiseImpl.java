package org.laba2.security;

import org.laba2.entities.Manager;
import org.laba2.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userdatails")
public class UserDatailsServiseImpl implements UserDetailsService {

    private final ManagerService managerService;

    @Autowired
    public UserDatailsServiseImpl(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerService.getManagerByLogin(username);
        if(manager == null) {
            throw new UsernameNotFoundException("User doesn`t exist");
        }
        return SecurityUser.fromUser(manager);
    }
}
