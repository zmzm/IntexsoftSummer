package by.intexsoft.calculator;

import java.util.Scanner;

/**
 * Created by Admin on 20.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(Operation.valueOf(command).call(a,b));
    }
}
