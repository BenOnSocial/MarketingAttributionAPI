package com.bentrandigital.marketingattribution.lead;

import com.bentrandigital.marketingattribution.lead.dto.LeadRequest;
import com.bentrandigital.marketingattribution.lead.score.LeadScore;
import com.bentrandigital.marketingattribution.lead.score.ScoringEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeadService {
    private final LeadRepository leadRepository;
    private final ScoringEngine scoringEngine;

    public LeadService(LeadRepository leadRepository, ScoringEngine scoringEngine) {
        this.leadRepository = leadRepository;
        this.scoringEngine = scoringEngine;
    }

    @Transactional
    public Lead save(LeadRequest request) {
        Lead lead = Lead.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .company(request.company())
                .jobTitle(request.jobTitle())
                .employees(request.employees())
                .build();

        LeadScore score = scoringEngine.compute(request);


        return leadRepository.save(lead);
    }
}
