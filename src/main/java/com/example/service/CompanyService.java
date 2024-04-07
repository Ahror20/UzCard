package com.example.service;

import com.example.dto.CRUDCompanyDTO;
import com.example.dto.CompanyDTO;
import com.example.entity.CompanyEntity;
import com.example.enums.CompanyRole;
import com.example.exp.AppBadException;
import com.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public CompanyDTO create(CRUDCompanyDTO dto) {
        if (dto.getRole().equals(CompanyRole.BANK)){
            if (dto.getCode().isEmpty()){
                throw new AppBadException("code is null");
            }
        }

       var companyEntity = new CompanyEntity();
       companyEntity.setName(dto.getName());
       companyEntity.setUsername(dto.getUsername());
       companyEntity.setCode(dto.getCode());
       companyEntity.setContact(dto.getContact());
       companyEntity.setAddress(dto.getAddress());
       companyEntity.setPassword(dto.getPassword());
       companyEntity.setRole(dto.getRole());
       companyRepository.save(companyEntity);

        return toDTO(companyEntity);
    }

    private CompanyDTO toDTO(CompanyEntity companyEntity){
        CompanyDTO dto =new CompanyDTO();
        dto.setId(companyEntity.getId());
        dto.setCode(companyEntity.getCode());
        dto.setRole(companyEntity.getRole());
        dto.setContact(companyEntity.getContact());
        dto.setAddress(companyEntity.getAddress());
        dto.setVisible(companyEntity.getVisible());
        dto.setCreatedDate(companyEntity.getCreatedDate());
        dto.setUsername(companyEntity.getUsername());
        dto.setPassword(companyEntity.getPassword());
        dto.setRole(companyEntity.getRole());
        return dto;

    }
}
