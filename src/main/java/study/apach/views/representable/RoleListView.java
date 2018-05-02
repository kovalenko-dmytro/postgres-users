package study.apach.views.representable;

import study.apach.model.entities.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoleListView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        List<Role> roles = new ArrayList<>();
        for (Object o : data) {
            roles.add((Role) o);
        }

        System.out.println("existing roles: ");
        for (Role role : roles) {
            System.out.println(" - " + role.getDescription());
        }
    }
}
