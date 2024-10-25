package com.Matteof.mattos.DsEcommerce_spring.Dto;

import com.Matteof.mattos.DsEcommerce_spring.entities.Role;
import com.Matteof.mattos.DsEcommerce_spring.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;

    private String email;

    private String password;

    private List<RoleDto> roles = new ArrayList<>();

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();

        for (Role role: user.getRoles()){
            roles.add(new RoleDto(role.getId(),role.getAuthority()));
        }
    }
}
