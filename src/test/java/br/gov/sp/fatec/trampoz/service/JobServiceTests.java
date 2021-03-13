package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Company;
import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.entity.Job;
import br.gov.sp.fatec.trampoz.mocks.CompanyMock;
import br.gov.sp.fatec.trampoz.mocks.FreelancerMock;
import br.gov.sp.fatec.trampoz.mocks.JobMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class JobServiceTests {
    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FreelancerService freelancerService;

    private final Company company = CompanyMock.getMockCompany();
    private final Freelancer freelancer = FreelancerMock.getMockFreelancer();
    private final Job job = JobMock.getMockJob();

    @BeforeAll
    void init() {
        companyService.create(company);
        freelancerService.create(freelancer);

        job.setCompany(company);
        job.getAppliedFreelancers().add(freelancer);
        jobService.create(job);
    }

    @AfterAll
    void exit() {
        jobService.delete(job.getId());
        companyService.delete(company.getId());
        freelancerService.delete(freelancer.getId());
    }

    @Test
    void shouldFindByIsOpen() {
        List<Job> jobs = new ArrayList<>(jobService.findByIsOpen(true));
        List<Job> empty = new ArrayList<>(jobService.findByIsOpen(false));

        Assertions.assertEquals(1, jobs.size());
        Assertions.assertEquals(0, empty.size());
    }

    @Test
    void shouldCountByIsOpen() {
        Assertions.assertEquals(1, jobService.countByIsOpen(true));
        Assertions.assertEquals(0, jobService.countByIsOpen(false));
    }

    @Test
    void shouldFindByTitle() {
        List<Job> jobs = new ArrayList<>(jobService.findByTitle(job.getTitle()));
        List<Job> empty = new ArrayList<>(jobService.findByTitle("banana"));

        Assertions.assertEquals(1, jobs.size());
        Assertions.assertEquals(0, empty.size());
    }

    @Test
    void shouldFindById() {
        UUID jobId = job.getId();
        UUID freelancerId = freelancer.getId();

        Assertions.assertTrue(jobService.findById(jobId).isPresent());
        Assertions.assertTrue(jobService.findById(freelancerId).isEmpty());
    }
}
