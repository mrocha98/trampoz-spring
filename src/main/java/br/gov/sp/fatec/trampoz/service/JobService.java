package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

}
