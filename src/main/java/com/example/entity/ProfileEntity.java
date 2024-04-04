package com.example.entity;

import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity extends BaseEntity{
     @Column(name = "name")
     private String name;
     @Column(name = "surname")
     private String surname;
     @Column(name = "status")
     @Enumerated(value = EnumType.STRING)
     private ProfileStatus status;
     @Column(name = "role")
     @Enumerated(value = EnumType.STRING)
     private ProfileRole role;
     @Column(name = "username",unique = true)
     private  String username;
     @Column(name = "password")
     private String password;
     @Column(name = "phone",unique = true)
     private String phone;
     @Column(name = "email")
     private String email;
}
