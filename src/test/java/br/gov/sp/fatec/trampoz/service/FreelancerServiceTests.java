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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class FreelancerServiceTests {

    @Autowired
    private FreelancerService freelancerService;

    private final Freelancer freelancer = FreelancerMock.getMockFreelancer();

    @BeforeAll
    void init() {
        freelancerService.create(freelancer);
    }

    @AfterAll
    void exit() {
        freelancerService.delete(freelancer.getId());
    }

    @Test
    void shouldFindByEmail() {
        String email = freelancer.getEmail();
        List<Freelancer> found = new ArrayList<>(freelancerService.findByEmail(email));

        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(email, found.get(0).getEmail());
    }

    @Test
    void shouldFindById() {
        Assertions.assertTrue(freelancerService.findById(freelancer.getId()).isPresent());
        Assertions.assertTrue(freelancerService.findById(UUID.randomUUID()).isEmpty());
    }

    @Test
    void shouldCreateWithResume() {
        Freelancer testFreelancer = FreelancerMock.getMockFreelancer();
        testFreelancer.setEmail("test@test.com");

        Resume testResume = ResumeMock.getMockResume();
        testResume.setFreelancer(testFreelancer);

        freelancerService.createWithResume(testFreelancer, testResume);

        Assertions.assertNotNull(testFreelancer.getId());
        Assertions.assertNotNull(testResume.getId());
    }

}
