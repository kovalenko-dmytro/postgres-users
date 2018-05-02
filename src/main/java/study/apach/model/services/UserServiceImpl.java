package study.apach.model.services;

import study.apach.model.entities.User;
import study.apach.model.entities.Role;
import study.apach.model.repositories.UserRepository;
import study.apach.model.repositories.UserRepositoryImpl;
import study.apach.model.repositories.RoleRepository;
import study.apach.model.repositories.RoleRepositoryImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
        roleRepository = new RoleRepositoryImpl();
    }

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User selectById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void insertUser(Map<String, String> params) {
        User insertedUser = populateBookData(-1, params);
        userRepository.save(insertedUser);
    }

    @Override
    public void updateUser(long id, Map<String, String> params) {
        User updatedUser = populateBookData(id, params);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public Collection<User> searchUsersByRole(String roleDescription) {
        Role role = roleRepository.findByDescription(roleDescription);
        return userRepository.findByRole(role.getId());
    }

    @Override
    public void insertUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    private User populateBookData(long id, Map<String, String> params) {

        User user = userRepository.findOne(id) == null ? new User() : userRepository.findOne(id);
        long roleId = roleRepository.findByDescription(params.get("role")).getId();

        user.setName(params.get("name"));
        user.setAge(Integer.parseInt( params.get("age")));
        user.setRoleId(roleId);

        return user;
    }
}
