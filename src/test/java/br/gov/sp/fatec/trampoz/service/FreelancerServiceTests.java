package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Freelancer;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class FreelancerServiceTests {

    @Autowired
    private FreelancerService freelancerService;

    @Autowired
    private RoleService roleService;

    private Freelancer freelancer = new Freelancer();

    @BeforeAll
    void init() {
        freelancer.setRole(roleService.findByName(RoleNameEnum.FREELANCER));
        freelancer.setName("Arthur");
        freelancer.setBio("19 ano, Caçapava - SP e é nois :D");
        freelancer.setAvatarLink("facebook.com/EuMesmo");
        freelancer.setEmail("arthurreis758@gmail.com");
        freelancer.setPassword("passwordForte");
        freelancer.setPricePerHour(new BigDecimal("15.19"));

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
}
