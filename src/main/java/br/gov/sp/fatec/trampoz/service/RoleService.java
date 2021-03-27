package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Role;
import br.gov.sp.fatec.trampoz.enums.RoleNameEnum;
import br.gov.sp.fatec.trampoz.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(RoleNameEnum name) {
        return roleRepository.findByName(name).get(0);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}
