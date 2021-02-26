package br.gov.sp.fatec.trampoz.repository;

import br.gov.sp.fatec.trampoz.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
}
