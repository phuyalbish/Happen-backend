package com.happen.happen_app.mapper;

import com.happen.happen_app.dto.RoleDto;
import com.happen.happen_app.entity.Role;

public class RoleMapper {

    public static Role mapToRole(RoleDto dto) {
        if (dto == null) return null;

        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUsers(dto.getUsers());
        return entity;
    }

    public static RoleDto mapToRoleDto(Role entity) {
        if (entity == null) return null;

        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUsers(entity.getUsers());
        return dto;
    }
}