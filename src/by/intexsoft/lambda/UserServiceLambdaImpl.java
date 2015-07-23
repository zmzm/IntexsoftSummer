package by.intexsoft.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 23.07.2015.
 */
public class UserServiceLambdaImpl implements UserService {
    private List<User> users;
    private List<String> names = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();

    UserServiceLambdaImpl(List<User> users){
        this.users = users;
    }

    @Override
    public List<Integer> getUsersIds() {
        ids = users.stream().map((user) -> user.getId()).collect(Collectors.toList());
        return ids;
    }

    @Override
    public List<String> getUsersNames() {
        names = users.stream().map((user) -> user.getName()).collect(Collectors.toList());
        return names;
    }
}
