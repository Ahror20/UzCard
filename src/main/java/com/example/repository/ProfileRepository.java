package com.example.repository;

import com.example.entity.ProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity,String> {
    Optional<ProfileEntity> findByUsername(String username);

    @Query(value = "SELECT * FROM profile WHERE username=?1 AND password=?2 AND visible=true AND status='ACTIVE' ", nativeQuery = true)
    Optional<ProfileEntity> getProfile(String username, String password);
}
