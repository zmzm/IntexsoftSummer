package by.intexsoft.jdbc;

/**
 * Created by Admin on 24.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        DataBase.createDB();
        DataBase.table("one");
        DataBase.table("two");

    }
}
