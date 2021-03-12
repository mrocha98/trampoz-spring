package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Company;
import br.gov.sp.fatec.trampoz.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    public List<Company> findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj);
    }

    @Transactional
    public void create(Company company) {
        companyRepository.save(company);
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
