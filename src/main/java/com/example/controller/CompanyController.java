package com.example.controller;

import com.example.dto.CRUDCompanyDTO;
import com.example.dto.CompanyDTO;
import com.example.service.CompanyService;
import com.example.util.SpringSecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Api for company create", description = "this api company create")
    public ResponseEntity<?> create(@Valid @RequestBody CRUDCompanyDTO dto){
        log.info("craete company {} ",SpringSecurityUtil.getCurrentUser().getId());
        return ResponseEntity.ok(companyService.create(dto));
    }
}
