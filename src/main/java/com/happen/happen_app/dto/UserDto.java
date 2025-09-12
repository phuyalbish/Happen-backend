package com.happen.happen_app.dto;

import com.happen.happen_app.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String profileUrl;
    private Boolean isActive;
    private Boolean isEmailVerified;
    private List<Role> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
