package com.example.repository;

import com.example.entity.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<CompanyEntity,String> {

    @Query(value = "select * from company  where username =?1 and password=?2 ",nativeQuery = true)
    Optional<CompanyEntity> getCompanyForCreate(String username, String password);
}
