package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "com_companies")
@PrimaryKeyJoinColumn(name = "com_id")
public class Company extends User {

    @Column(name = "com_cnpj", unique = true)
    private String cnpj;

    @Column(name = "com_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Job> jobs = new HashSet<>();

}
