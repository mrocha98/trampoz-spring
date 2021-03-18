package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Company;
import br.gov.sp.fatec.trampoz.entity.Job;
import br.gov.sp.fatec.trampoz.mocks.CompanyMock;
import br.gov.sp.fatec.trampoz.mocks.JobMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class CompanyServiceTests {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobService jobService;

    private final Company company = CompanyMock.getMockCompany();
    private final List<Job> jobs = new ArrayList<>(
        Arrays.asList(
            JobMock.getMockJob(true),
            JobMock.getMockJob(false)
        )
    );

    @BeforeAll
    public void init() {
        companyService.create(company);
        jobs.forEach(job -> {
            job.setCompany(company);
            jobService.create(job);
        });
    }

    @AfterAll
    public void exit() {
        jobs.forEach(job -> jobService.delete(job.getId()));
        companyService.delete(company.getId());
    }

    @Test
    public void shouldFindByEmail() {
        String email = company.getEmail();
        List<Company> found = new ArrayList<>(companyService.findByEmail(email));

        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(email, found.get(0).getEmail());
    }

    @Test
    public void shouldFindByCnpj() {
        String cnpj = company.getCnpj();
        List<Company> found = new ArrayList<>(companyService.findByCnpj(cnpj));

        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(cnpj, found.get(0).getCnpj());
    }

    @Test
    public void shouldFindById() {
        Assertions.assertTrue(companyService.findById(company.getId()).isPresent());
        Assertions.assertTrue(companyService.findById(UUID.randomUUID()).isEmpty());
    }

    @Test
    public void shouldCountJobs() {
        Assertions.assertEquals(2, companyService.countJobs(company.getId()));
    }

    @Test
    public void shouldCountAndFilterByIsOpen() {
        Assertions.assertEquals(1, companyService.countJobsAndFilterByIsOpen(company.getId(), true));
    }

    @Test
    public void shouldCreateWithJobs() {
        Company testCompany = CompanyMock.getMockCompany();
        testCompany.setEmail("test@test.com");

        List<Job> testJobs = new ArrayList<>(
            Arrays.asList(
                JobMock.getMockJob(),
                JobMock.getMockJob(),
                JobMock.getMockJob(),
                JobMock.getMockJob()
            )
        );

        companyService.createWithJobs(testCompany, testJobs);

        Assertions.assertNotNull(testCompany.getId());
        Assertions.assertEquals(4, testJobs.size());
        testJobs.forEach(job -> Assertions.assertNotNull(job.getId()));
    }
}
