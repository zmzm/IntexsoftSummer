package by.intexsoft.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Admin on 23.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "aaaaa");
        User user2 = new User(2, "bbbbb");
        User user3 = new User(3, "ccccc");
        List<User> users = Arrays.asList(user1, user2, user3);

        UserServiceLoopsImpl loops = new UserServiceLoopsImpl(users);
        List<Integer> loopIds = loops.getUsersIds();
        List<String> loopNames = loops.getUsersNames();

        loopIds.forEach(System.out::print);
        System.out.println("");
        loopNames.forEach(System.out::print);
        System.out.println(System.lineSeparator());

        UserServiceLambdaImpl lambda = new UserServiceLambdaImpl(users);
        List<Integer> lambdaIds = lambda.getUsersIds();
        List<String> lambdaNames = lambda.getUsersNames();

        lambdaIds.forEach(System.out::print);
        System.out.println("");
        lambdaNames.forEach(System.out::print);

    }
}
