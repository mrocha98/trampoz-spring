package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "adm_admins")
@PrimaryKeyJoinColumn(name = "adm_id")
public class Admin extends User {
}
