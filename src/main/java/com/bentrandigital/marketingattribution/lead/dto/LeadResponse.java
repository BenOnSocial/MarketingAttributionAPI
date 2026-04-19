package com.bentrandigital.marketingattribution.lead.dto;

import jakarta.validation.constraints.Positive;

public record LeadResponse (
    @Positive Integer totalScore,
    Boolean isMyql
) {}
