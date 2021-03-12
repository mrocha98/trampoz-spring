package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FreelancerService {
    @Autowired
    private FreelancerRepository freelancerRepository;

    public List<Freelancer> findByEmail(String email) {
        return freelancerRepository.findByEmail(email);
    }

    @Transactional
    public void create(Freelancer freelancer) {
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
