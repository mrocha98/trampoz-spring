package br.gov.sp.fatec.trampoz.mocks;

import br.gov.sp.fatec.trampoz.entity.Resume;

public class ResumeMock {
    public static Resume getMockResume() {
        Resume resume = new Resume();

        resume.setLinkedinLink("Linkedinho.com/EuMesmo");
        resume.setProfessionalExperience("Gamer com mais de 10 anos de exp. acumulada");
        resume.setSkills("sei dirigir, na vida real e nos jogos");

        return resume;
    }
}
