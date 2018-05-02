package study.apach.views.representable;

import study.apach.model.entities.User;

import java.util.Collection;

public class SingleObjectView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        User user = (User) data.iterator().next();

        System.out.println("*****************************************");
        if (user.getId() == 0) {

            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|       NO SUCH USER IS AVAILABLE       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("*****************************************");
            System.out.println("Back to list? [list]");

        } else {

            System.out.println("User: " + user.getName());
            System.out.println("*****************************************");
            System.out.println("id: " + user.getId());
            System.out.println("name: " + user.getName());
            System.out.println("age: " + user.getAge());
            System.out.println("role: " + user.getRoleDescription());
            System.out.println();
            System.out.println("Update? [update], " +
                                "Delete? [delete], " +
                                "Back to list? [list]");

        }
    }
}
