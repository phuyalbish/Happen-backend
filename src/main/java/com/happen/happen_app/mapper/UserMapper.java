package com.happen.happen_app.mapper;

import com.happen.happen_app.dto.UserDto;
import com.happen.happen_app.entity.Role;
import com.happen.happen_app.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToUser(UserDto dto) {
        if (dto == null) return null;

        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPhone(dto.getPhone());
        entity.setProfileUrl(dto.getProfileUrl());
        entity.setIsActive(dto.getIsActive());
        entity.setIsEmailVerified(dto.getIsEmailVerified());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setRoles(dto.getRoles());
        return entity;
    }
    public static UserDto mapToUserDto(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPhone(entity.getPhone());
        dto.setProfileUrl(entity.getProfileUrl());
        dto.setIsActive(entity.getIsActive());
        dto.setIsEmailVerified(entity.getIsEmailVerified());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRoles(entity.getRoles());
        return dto;
    }
}