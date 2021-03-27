package br.gov.sp.fatec.trampoz.mocks;

import br.gov.sp.fatec.trampoz.entity.Job;

public class JobMock {
    public static Job getMockJob() {
        Job job = new Job();

        job.setTitle("Criar blog com WordPress");
        job.setDescription("Precisamos de um blog urgente");
        job.setIsOpen(true);

        return job;
    }

    public static Job getMockJob(Boolean isOpen) {
        Job job = JobMock.getMockJob();
        job.setIsOpen(isOpen);
        return job;
    }
}
