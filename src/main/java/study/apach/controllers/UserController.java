package study.apach.controllers;

import study.apach.model.entities.User;
import study.apach.model.services.UserService;
import study.apach.model.services.UserServiceImpl;
import study.apach.views.View;
import study.apach.views.representable.UserListView;
import study.apach.views.representable.SingleObjectView;

import java.util.List;
import java.util.Map;

public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserServiceImpl();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getUsers() {
        List<User> users = (List<User>) userService.selectAll();
        View listView = new View(new UserListView());
        listView.setData(users);
        listView.render();
    }

    public void getUsers(String roleName) {
        List<User> users = (List<User>) userService.searchUsersByRole(roleName);
        View listView = new View(new UserListView());
        listView.setData(users);
        listView.render();
    }

    public void viewUser(long id) {
        User user = userService.selectById(id);
        View userView = new View(new SingleObjectView());
        userView.setData(user);
        userView.render();
    }

    public void createUser(Map<String, String> params) {
        userService.insertUser(params);
    }

    public void updateUser(long id, Map<String, String> params) {
        userService.updateUser(id, params);
    }

    public void deleteUser(long id) {
        userService.deleteUser(id);
    }


}
