package study.apach.model.services;

import study.apach.model.entities.Role;
import study.apach.model.repositories.RoleRepository;
import study.apach.model.repositories.RoleRepositoryImpl;

import java.util.Collection;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl() {
        roleRepository = new RoleRepositoryImpl();
    }

    @Override
    public Collection<Role> selectAll() {
        return roleRepository.findAll();
    }
}
