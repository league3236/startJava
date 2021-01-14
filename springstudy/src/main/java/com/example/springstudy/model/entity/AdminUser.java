package com.example.springstudy.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AdminUser {

    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    
}
