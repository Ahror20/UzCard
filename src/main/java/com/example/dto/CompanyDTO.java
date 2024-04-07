package com.example.dto;

import com.example.enums.CompanyRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private CompanyRole role;
    private String code;
    private String username;
    private String password;
    private LocalDateTime createdDate;
    private Boolean visible;


}
