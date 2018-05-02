package study.apach.model.repositories;

import study.apach.model.entities.User;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {

    Collection<User> findByRole(long roleId);
}
