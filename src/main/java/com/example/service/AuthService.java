package com.example.service;

import com.example.dto.AuthDTO;
import com.example.dto.ProfileDTO;
import com.example.entity.ProfileEntity;
import com.example.exp.AppBadException;
import com.example.repository.ProfileRepository;
import com.example.util.JWTUtil;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    public ProfileDTO login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.getProfile(dto.getUsername(), MD5Util.getMd5(dto.getPassword()));
        if (optional.isEmpty()) {
            throw new AppBadException("profile not found");
        }

        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(optional.get().getName());
        profileDTO.setSurname(optional.get().getSurname());
        profileDTO.setRole(optional.get().getRole());
        profileDTO.setJwt(JWTUtil.encode(optional.get().getEmail(), optional.get().getRole()));
        return profileDTO;
    }
}
