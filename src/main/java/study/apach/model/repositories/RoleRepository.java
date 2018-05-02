package study.apach.model.repositories;

import study.apach.model.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByDescription(String roleDescription);
}
