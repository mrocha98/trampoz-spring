package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.entity.Resume;
import br.gov.sp.fatec.trampoz.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private FreelancerService freelancerService;

    public Optional<Resume> findById(UUID id) {
        return resumeRepository.findById(id);
    }

    @Transactional
    public void create(Resume resume) {
        resumeRepository.save(resume);
    }

    @Transactional
    public void create(Resume resume, UUID freelancerId) {
        Optional<Freelancer> freelancer = freelancerService.findById(freelancerId);
        if (freelancer.isEmpty()) throw new IllegalArgumentException("cannot find an freelancer with provided id");

        resume.setFreelancer(freelancer.get());
        this.create(resume);
    }

    @Transactional
    public void delete(UUID id) {
        resumeRepository.deleteById(id);
    }

    @Transactional
    public void update(Resume resume) {
        resumeRepository.save(resume);
    }
}
