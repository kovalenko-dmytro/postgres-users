package study.apach.views.representable;

import study.apach.model.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class UserListView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        List<User> users = new ArrayList<>();
        for (Object o : data) {
            users.add((User) o);
        }

        users.sort(Comparator.comparingLong((User::getId)));

        System.out.println("*******************************************************");
        System.out.println("|                   LIST OF USERS                     |");
        System.out.println("*******************************************************");
        if (data.isEmpty()) {

            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("|              NO USERS ARE AVAILABLE                 |");
            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("*******************************************************");
            System.out.println();
            System.out.println("Back to index? [index]");

        } else {

            users.forEach(user -> {
                System.out.println("id: " + user.getId() + " | " +
                                    " name: " + user.getName() + " | " +
                                    " age: " + user.getAge() + " | " +
                                    " role: " + user.getRoleDescription()
                                    );
            });

            System.out.println();
            System.out.println("Back to index? [index], " +
                                "View user? [id]");

        }
    }
}
