package com.bentrandigital.marketingattribution.lead.score;

import com.bentrandigital.marketingattribution.lead.dto.LeadRequest;
import org.springframework.stereotype.Component;

@Component
public class ScoringEngine {
    public LeadScore compute(LeadRequest request) {
        int score = 0;

        if (request.jobTitle() != null && request.jobTitle().matches("(?i).*(vp|director|chief|head).*")) score += 30;
        if (request.employees() != null) {
            if (request.employees() > 500) score += 20;
            if (request.employees() > 5000) score += 10;
        }
        if ("linkedin".equalsIgnoreCase(request.source())) score += 15;
        if ("organic".equalsIgnoreCase(request.source())) score += 5;

        return LeadScore.builder()
                .totalScore(score)
                .isMql(score >= 40)
                .build();
    }
}
