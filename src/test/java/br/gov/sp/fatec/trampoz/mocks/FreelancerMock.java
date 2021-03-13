package br.gov.sp.fatec.trampoz.mocks;

import br.gov.sp.fatec.trampoz.entity.Freelancer;

import java.math.BigDecimal;

public class FreelancerMock {
    public static Freelancer getMockFreelancer() {
        Freelancer freelancer = new Freelancer();

        freelancer.setName("Arthur");
        freelancer.setBio("19 ano, Caçapava - SP e é nois :D");
        freelancer.setAvatarLink("facebook.com/EuMesmo");
        freelancer.setEmail("arthurreis758@gmail.com");
        freelancer.setPassword("passwordForte");
        freelancer.setPricePerHour(new BigDecimal("15.19"));

        return freelancer;
    }
}
