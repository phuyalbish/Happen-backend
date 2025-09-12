package com.happen.happen_app.service;

import com.happen.happen_app.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(Long id);
    List<RoleDto> getAllRoles();
    RoleDto updateRole(Long id, RoleDto roleDto);
    void deleteRole(Long id);
}
