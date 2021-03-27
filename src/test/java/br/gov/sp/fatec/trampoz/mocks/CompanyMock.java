package br.gov.sp.fatec.trampoz.mocks;

import br.gov.sp.fatec.trampoz.entity.Company;

public class CompanyMock {
    public static Company getMockCompany() {
        Company company = new Company();

        company.setName("Juquinha Lanches");
        company.setEmail("jlanches@email.com");
        company.setPassword("SenhaF0rte");
        company.setAvatarLink("https://pudim.com.br");
        company.setCnpj("123456789");

        return company;
    }
}
