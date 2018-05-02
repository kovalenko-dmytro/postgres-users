package study.apach.views.representable;

import java.util.Collection;

public class IndexView implements Representable {

    @Override
    public void render(Collection<Object> data) {
        System.out.println("**********************************************");
        System.out.println("|            USERS INDEX PAGE                |");
        System.out.println("**********************************************");
        System.out.println("| Options:                                   |");
        System.out.println("|        'upload'. Upload data from file     |");
        System.out.println("|        'list'.   View list of users        |");
        System.out.println("|        'search'. Search user by role       |");
        System.out.println("|        'create'. Create user               |");
        System.out.println("|        'exit'.   Exit                      |");
        System.out.println("**********************************************");
    }
}
