package by.intexsoft.lambda;

import by.intexsoft.reflection.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 23.07.2015.
 */
public class UserServiceLoopsImpl implements UserService {
    private List<User> users;
    private List<String> names = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();

    public UserServiceLoopsImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<Integer> getUsersIds() {
        for (int i = 0; i < users.size(); i++) {
            ids.add(users.get(i).getId());
        }
        return ids;
    }

    @Override
    public List<String> getUsersNames() {
        for (int i = 0; i < users.size(); i++) {
            names.add(users.get(i).getName());
        }
        return names;
    }
}
