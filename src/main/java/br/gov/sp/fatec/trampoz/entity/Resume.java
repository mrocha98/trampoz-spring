package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "res_resumes")
@AttributeOverride(name = "id", column = @Column(name = "res_id"))
public class Resume extends Base {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fre_id")
    private Freelancer freelancer;

    @Column(name = "res_linkedin_link", columnDefinition = "text")
    private String LinkedinLink;

    @Column(name = "res_professional_experience", columnDefinition = "text")
    private String ProfessionalExperience;

    @Column(name = "res_skills", columnDefinition = "text")
    private String skills;

}
