package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Company;
import br.gov.sp.fatec.trampoz.entity.Job;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import br.gov.sp.fatec.trampoz.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JobService jobService;

    public Optional<Company> findById(UUID id) {
        return companyRepository.findById(id);
    }

    public List<Company> findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    public List<Company> findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj);
    }

    public Long countJobs(UUID companyId) {
        return companyRepository.countJobs(companyId);
    }

    public Long countJobsAndFilterByIsOpen(UUID id, Boolean isOpen) {
        return companyRepository.countJobsAndFilterByIsOpen(id, isOpen);
    }

    @Transactional
    public void create(Company company) {
        company.setRole(roleService.findByName(RoleNameEnum.COMPANY));
        companyRepository.save(company);
    }

    @Transactional
    public void createWithJobs(Company company, List<Job> jobs) {
        this.create(company);

        jobs.forEach(job -> {
            job.setCompany(company);
            jobService.create(job);
        });
    }

    @Transactional
    public void update(Company company) {
        companyRepository.save(company);
    }

    @Transactional
    public void delete(UUID id) {
        companyRepository.deleteById(id);
    }

}
