package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_jobs")
@AttributeOverride(name = "id", column = @Column(name = "job_id"))
public class Job extends Base {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "com_id")
    private Company company;

    @Column(name = "job_title", columnDefinition = "text")
    private String title;

    @Column(name = "job_description", columnDefinition = "text")
    private String description;

    @Column(name = "job_is_open")
    private Boolean isOpen;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "jap_job_applications",
        joinColumns = {@JoinColumn(name = "job_id")},
        inverseJoinColumns = {@JoinColumn(name = "fre_id")}
    )
    private Set<Freelancer> appliedFreelancers = new HashSet<>();

}
