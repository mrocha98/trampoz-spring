package br.gov.sp.fatec.trampoz.entity;

import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rol_roles")
public class Role {

    @Id
    @Column(name = "rol_id")
    private UUID id;

    @Column(name = "rol_name")
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users;

}
