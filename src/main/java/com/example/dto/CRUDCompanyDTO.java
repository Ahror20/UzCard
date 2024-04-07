package com.example.dto;

import com.example.enums.CompanyRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDCompanyDTO {
    @NotNull
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String contact;
    @NotBlank
    private CompanyRole role;
    private String code;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
