package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Company;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@Rollback
public class CompanyServiceTests {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RoleService roleService;

    private Company company = new Company();

    @BeforeAll
    public void init() {
        company.setRole(roleService.findByName(RoleNameEnum.COMPANY));
        company.setName("Juquinha Lanches");
        company.setEmail("jlanches@email.com");
        company.setPassword("SenhaF0rte");
        company.setAvatarLink("https://pudim.com.br");
        company.setCnpj("123456789");

        companyService.create(company);
    }

    @AfterAll
    public void exit() {
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
}
