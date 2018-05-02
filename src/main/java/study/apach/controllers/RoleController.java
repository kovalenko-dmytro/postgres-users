package study.apach.controllers;

import study.apach.model.entities.Role;
import study.apach.model.services.RoleService;
import study.apach.model.services.RoleServiceImpl;
import study.apach.views.View;
import study.apach.views.representable.RoleListView;

import java.util.List;

public class RoleController {

    private RoleService roleService;

    public RoleController() {
        roleService = new RoleServiceImpl();
    }

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public void getRoles() {

        List<Role> roles = (List<Role>) roleService.selectAll();
        View rolesView = new View(new RoleListView());
        rolesView.setData(roles);
        rolesView.render();

    }
}
