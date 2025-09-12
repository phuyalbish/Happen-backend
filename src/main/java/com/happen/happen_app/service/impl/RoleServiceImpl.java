package com.happen.happen_app.service.impl;
import org.springframework.stereotype.Service;
import com.happen.happen_app.entity.Role;
import com.happen.happen_app.dto.RoleDto;
import com.happen.happen_app.mapper.RoleMapper;
import com.happen.happen_app.repository.RoleRepository;
import com.happen.happen_app.service.RoleService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = RoleMapper.mapToRole(roleDto);
        Role savedRole = roleRepository.save(role);
        return RoleMapper.mapToRoleDto(savedRole);
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role does not exist"));
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleMapper::mapToRoleDto)
                .collect(Collectors.toList());
    }


    @Override
    public RoleDto updateRole(Long id, RoleDto dto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role does not exist"));
        role.setId(dto.getId());
        role.setRolename(dto.getRolename());
        role.setEmail(dto.getEmail());
        role.setPassword(dto.getPassword());
        role.setFirstname(dto.getFirstname());
        role.setLastname(dto.getLastname());
        role.setPhone(dto.getPhone());
        role.setProfileUrl(dto.getProfileUrl());
        role.setIsActive(dto.getIsActive());
        role.setIsEmailVerified(dto.getIsEmailVerified());
        role.setCreatedAt(dto.getCreatedAt());
        role.setUpdatedAt(dto.getUpdatedAt());
        role.setRoles(dto.getRoles());
        Role updatedRole = roleRepository.save(role);
        return RoleMapper.mapToRoleDto(updatedRole);
    }


    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role does not exist");
        }
        roleRepository.deleteById(id);
    }

}