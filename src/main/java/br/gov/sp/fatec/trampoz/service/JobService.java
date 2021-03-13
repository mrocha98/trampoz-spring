package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Job;
import br.gov.sp.fatec.trampoz.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Optional<Job> findById(UUID id) {
        return jobRepository.findById(id);
    }

    public List<Job> findByTitle(String text) {
        return jobRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Job> findByIsOpen(Boolean isOpen) {
        return jobRepository.findByIsOpen(isOpen);
    }

    public Long countByIsOpen(Boolean isOpen) {
        return jobRepository.countByIsOpen(isOpen);
    }

    @Transactional
    public void create(Job job) {
        jobRepository.save(job);
    }

    @Transactional
    public void delete(UUID id) {
        jobRepository.deleteById(id);
    }

    @Transactional
    public void update(Job job) {
        jobRepository.save(job);
    }

}
