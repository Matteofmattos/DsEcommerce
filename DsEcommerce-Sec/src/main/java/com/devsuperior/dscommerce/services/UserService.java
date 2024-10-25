package com.devsuperior.dscommerce.services;


import com.Matteof.mattos.DsEcommerce_spring.Repositories.UserRepository;
import com.Matteof.mattos.DsEcommerce_spring.entities.Role;
import com.Matteof.mattos.DsEcommerce_spring.entities.User;
import com.Matteof.mattos.DsEcommerce_spring.projection.UserDetailsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> userDetailsProjections = repository.searchUserAndRolesByEmail(username);

        if (userDetailsProjections.isEmpty()){
            throw new UsernameNotFoundException("user not found.");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(userDetailsProjections.get(0).getPassword());

        for (UserDetailsProjection projection: userDetailsProjections){
           user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }
}
