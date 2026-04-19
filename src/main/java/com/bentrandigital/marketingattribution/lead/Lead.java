package com.bentrandigital.marketingattribution.lead;

import com.bentrandigital.marketingattribution.lead.attribution.Attribution;
import com.bentrandigital.marketingattribution.lead.score.LeadScore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "leads")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private Integer employees;

    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    private Attribution attribution;

    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    private LeadScore score;

    @Column(updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public void setScore(LeadScore score) {
        this.score = score;
        score.setLead(this);
    }
}
