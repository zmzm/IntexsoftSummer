package by.intexsoft.reflection;

import java.lang.reflect.Field;

/**
 * Created by Admin on 22.07.2015.
 */
public class User extends AbstractPerson {
    @MyAnnotation(priority = 3, multiply = 3)
    private String name;
    @MyAnnotation(priority = 2, multiply = 4)
    private String address;
    @MyAnnotation(priority = 1, multiply = 5)
    private Integer date;

    public User(String name, String address, Integer date) {
        this.name = name;
        this.address = address;
        this.date = date;
    }
}
