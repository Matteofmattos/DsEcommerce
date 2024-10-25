package com.Matteof.mattos.DsEcommerce_spring.Dto;

import com.Matteof.mattos.DsEcommerce_spring.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;

    private String authority;

    public RoleDto(Role role) {
        this.id = role.getId();
        this.authority = role.getAuthority();
    }
}
