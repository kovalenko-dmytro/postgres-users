package study.apach.model.services;

import study.apach.model.entities.User;

import java.util.Collection;
import java.util.Map;

public interface UserService {

    Collection<User> selectAll();
    User selectById(long id);
    void insertUser(Map<String, String> params);
    void updateUser(long id, Map<String, String> params);
    void deleteUser(long id);
    Collection<User> searchUsersByRole(String roleDescription);

}
