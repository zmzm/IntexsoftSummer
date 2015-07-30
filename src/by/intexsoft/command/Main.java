package by.intexsoft.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Add add = new Add();
        Remove remove = new Remove();
        Find find = new Find();

        Map hash = new HashMap<String, Object>();
        hash.put("add", add);
        hash.put("find", find);
        hash.put("remove", remove);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        MultiCommand mult = new MultiCommand(hash, s);

        String command = mult.getCommand();
        System.out.println(mult.execute(command));
    }
}