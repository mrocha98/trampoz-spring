package br.gov.sp.fatec.trampoz.service;

import br.gov.sp.fatec.trampoz.entity.Admin;
import br.gov.sp.fatec.trampoz.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
