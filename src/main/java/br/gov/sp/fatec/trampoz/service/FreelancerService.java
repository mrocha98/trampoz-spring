package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import br.gov.sp.fatec.trampoz.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FreelancerService {
    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private RoleService roleService;

    public Optional<Freelancer> findById(UUID id) {
        return freelancerRepository.findById(id);
    }

    public List<Freelancer> findByEmail(String email) {
        return freelancerRepository.findByEmail(email);
    }

    @Transactional
    public void create(Freelancer freelancer) {
        freelancer.setRole(roleService.findByName(RoleNameEnum.FREELANCER));
        freelancerRepository.save(freelancer);
    }

    @Transactional
    public void update(Freelancer freelancer) {
        freelancerRepository.save(freelancer);
    }

    @Transactional
    public void delete(UUID id) {
        freelancerRepository.deleteById(id);
    }
}
