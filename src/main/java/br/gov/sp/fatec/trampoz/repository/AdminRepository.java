package br.gov.sp.fatec.trampoz.repository;

import br.gov.sp.fatec.trampoz.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    List<Admin> findByEmail(String email);
}
