package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.entity.Resume;
import br.gov.sp.fatec.trampoz.mocks.FreelancerMock;
import br.gov.sp.fatec.trampoz.mocks.ResumeMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class ResumeServiceTests {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private FreelancerService freelancerService;

    private final Resume resume = ResumeMock.getMockResume();
    private final Freelancer freelancer = FreelancerMock.getMockFreelancer();

    @BeforeAll
    void init() {
        freelancerService.create(freelancer);
        resumeService.create(resume, freelancer.getId());
    }

    @AfterAll
    void exit() {
        resumeService.delete(resume.getId());
        freelancerService.delete(freelancer.getId());
    }

    @Test
    void shouldFindById() {
        Assertions.assertTrue(resumeService.findById(resume.getId()).isPresent());
        Assertions.assertTrue(resumeService.findById(freelancer.getId()).isEmpty());
    }
}
