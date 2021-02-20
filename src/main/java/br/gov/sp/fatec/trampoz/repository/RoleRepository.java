package br.gov.sp.fatec.trampoz.repository;

import br.gov.sp.fatec.trampoz.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    public Role findByName(String name);
}
