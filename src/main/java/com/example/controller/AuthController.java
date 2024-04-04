package com.example.controller;

import com.example.dto.AuthDTO;
import com.example.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authorization Api list", description = "Api list for Authorization")
@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Api for login", description = "this api used for login")
    public ResponseEntity<?> registration(@Valid  @RequestBody AuthDTO dto) {
        log.info("login {}", dto.getUsername());
        return ResponseEntity.ok(authService.login(dto));
    }
}
