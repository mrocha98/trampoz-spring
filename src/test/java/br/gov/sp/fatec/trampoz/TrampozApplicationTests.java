package br.gov.sp.fatec.trampoz;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.trampoz.entity.*;
import br.gov.sp.fatec.trampoz.enums.*;
import br.gov.sp.fatec.trampoz.repository.*;

@SpringBootTest
@Transactional
@Rollback
class TrampozApplicationTests {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private FreelancerRepository freelaRepo;

    @Autowired
    private ResumeRepository resRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void testaFindByNameFreelancer() {
        Freelancer freela = new Freelancer();

        freela.setName("Arthur");
        freela.setBio("19 ano, Caçapava - SP e é nois :D");
        freela.setAvatarLink("facebook.com/EuMesmo");
        freela.setEmail("arthurreis758@gmail.com");
        freela.setPassword("passwordForte");
        freela.setPricePerHour(new BigDecimal(15));

        Resume resume = new Resume();
        resume.setFreelancer(freela);
        resume.setLinkedinLink("Linkedinho.com/EuMesmo");
        resume.setProfessionalExperience("Gamer com mais de 10 anos de exp. acumulada");
        resume.setSkills("sei dirigir, na vida real e nos jogos");

        resRepo.save(resume);

        freela.setResume(resume);

        Role role = roleRepo.findByName(RoleNameEnum.FREELANCER);
        freela.setRole(role);

        freelaRepo.save(freela);

        System.out.println("-".repeat(100));
        System.out.println(freelaRepo.findByName("Arthur").getName());
        System.out.println("-".repeat(100));

        assertNotNull(freelaRepo.findByName("Arthur"));
    }

}
