package br.com.wellingtoncosta.amd.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.wellingtoncosta.amd.domain.model.Color;
import br.com.wellingtoncosta.amd.domain.model.User;

/**
 * @author Wellington Costa on 30/12/2017.
 */
public class Mocks {

    public static List<User> createUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Foo", "Bar", null));
        users.add(new User(2, "Baa", "For", null));
        users.add(new User(3, "Boo", "Far", null));

        return users;
    }

    public static List<Color> createColors() {
        List<Color> colors = new ArrayList<>();

        colors.add(new Color(1, "Red", 2000, "#FF0000"));
        colors.add(new Color(2, "Green", 2001, "#00FF00"));
        colors.add(new Color(3, "Blue", 2002, "#0000FF"));

        return colors;
    }

}
