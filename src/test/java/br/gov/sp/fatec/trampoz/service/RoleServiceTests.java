package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Role;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RoleServiceTests {
    @Autowired
    private RoleService roleService;

    @Test
    void shouldReturnAnExistentAdminRole() {
        Role role = roleService.findByName(RoleNameEnum.ADMIN);
        Assertions.assertNotNull(role);
    }

    @Test
    void shouldReturnAnExistentCompanyRole() {
        Role role = roleService.findByName(RoleNameEnum.COMPANY);
        Assertions.assertNotNull(role);
    }

    @Test
    void shouldReturnAnExistentFreelancerRole() {
        Role role = roleService.findByName(RoleNameEnum.FREELANCER);
        Assertions.assertNotNull(role);
    }

    @Test
    void shouldReturnThreeRoles() {
        List<Role> roles = new ArrayList<>(roleService.findAll());
        Assertions.assertEquals(3, roles.size());
    }
}
