package com.bentrandigital.marketingattribution.lead.score;

import com.bentrandigital.marketingattribution.lead.Lead;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_score")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeadScore {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id", nullable = false, unique = true)
    @Setter
    private Lead lead;

    private int totalScore;
    private boolean isMql;

    @Column(name = "updated_at", updatable = true)
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
