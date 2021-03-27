package br.gov.sp.fatec.trampoz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fre_freelancers")
@PrimaryKeyJoinColumn(name = "fre_id")
public class Freelancer extends User {

    @Column(name = "fre_bio", columnDefinition = "text")
    private String bio;

    @Column(name = "fre_price_per_hour", columnDefinition = "decimal", precision = 5, scale = 2)
    private BigDecimal pricePerHour;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "freelancer")
    private Resume resume;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "jap_job_applications",
        joinColumns = {@JoinColumn(name = "fre_id")},
        inverseJoinColumns = {@JoinColumn(name = "job_id")}
    )
    private Set<Job> appliedJobs = new HashSet<>();

}
