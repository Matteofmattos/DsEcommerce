package com.Matteof.mattos.DsEcommerce_spring.entities;


import com.Matteof.mattos.DsEcommerce_spring.Dto.RoleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String authority;

    public Role(RoleDto roleDto) {
        this.id = roleDto.getId();
        this.authority = roleDto.getAuthority();
    }
}
