package com.bentrandigital.marketingattribution.lead.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record LeadRequest(
    @NotBlank @Email String email,
    @NotBlank String firstName,
    @NotBlank String lastName,
    String company,
    String jobTitle,
    @Positive Integer employees,
    @NotBlank String source,
    String campaign
) {}
