package br.gov.sp.fatec.trampoz.repository;

import br.gov.sp.fatec.trampoz.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    List<Company> findByEmail(String email);

    List<Company> findByCnpj(String cnpj);

    @Query("select count(filteredJobs) from Company c inner join c.jobs filteredJobs where c.id = ?1")
    Long countJobs(UUID companyId);

    @Query("select count(filteredJobs) from Company c inner join c.jobs filteredJobs where c.id = ?1 and filteredJobs.isOpen = ?2")
    Long countJobsAndFilterByIsOpen(UUID companyId, Boolean isOpen);
}
