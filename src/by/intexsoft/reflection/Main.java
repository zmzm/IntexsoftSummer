package by.intexsoft.reflection;

/**
 * Created by Admin on 22.07.2015.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        User user = new User("aaaa", "vvvvv", 1111);
        User user1 = new User("aaaa", "vvvvv", 1111);

        System.out.println("toString");
        System.out.println(user.toString() + System.lineSeparator());
        System.out.println("hashCode");
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode() + System.lineSeparator());
        System.out.println("equals");
        System.out.println(user.equals(user1) + System.lineSeparator());
        System.out.println("compareTo");
        System.out.println(user.compareTo(user1));
    }
}
