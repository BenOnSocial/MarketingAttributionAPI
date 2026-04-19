package com.bentrandigital.marketingattribution.lead;

import com.bentrandigital.marketingattribution.lead.dto.LeadRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leads")
public class LeadController {
    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody LeadRequest request)
    {
        Lead newLead = leadService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLead);
    }
}
