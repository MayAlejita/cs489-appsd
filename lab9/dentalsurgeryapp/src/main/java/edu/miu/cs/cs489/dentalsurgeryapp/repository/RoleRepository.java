package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Role;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;

public interface RoleRepository extends ListCrudRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
