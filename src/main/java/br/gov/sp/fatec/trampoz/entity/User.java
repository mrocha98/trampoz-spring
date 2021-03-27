package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usr_users")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "usr_id"))
public abstract class User extends Base {

    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_email", unique = true)
    private String email;

    @Column(name = "usr_password")
    private String password;

    @Column(name = "usr_avatar_link")
    private String avatarLink;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id")
    private Role role;

}
