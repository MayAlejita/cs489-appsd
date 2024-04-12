package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Role;

import java.util.List;

public interface RoleService {
    Role addNewRole(Role newRole);
    Role getRoleById(Integer roleId);
    Role updateRole(Role role);
    List<Role> getAllRoles();
    void deleteRoleById(Integer roleId);
}
