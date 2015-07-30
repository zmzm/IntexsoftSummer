package by.intexsoft.cabel;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 16.07.2015
 */
public class Main {

    private static int[] ar;
    private static final int x = 10000;

    static int getLength(int len) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i] / len;
            if (sum > x) return sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int n, k;
        Scanner sc = new Scanner(System.in);

        System.out.println("N: ");
        n = sc.nextInt();
        System.out.println("K: ");
        k = sc.nextInt();

        try {
            if (k == 0 || n == 0)
                throw new CustomException("Ошибка ввода!");

            ar = new int[n];
            int min = 1;
            int max = 1000;

            if ((k <= x) && (n <= x)) {
                for (int i = 0; i < n; i++) {
                    ar[i] = rnd.nextInt(900) + 100;
                    System.out.print(ar[i] + " ");
                }
            } else {
                System.out.println("ERROR!!!");
            }

            while (max > min + 1) {
                int a = (min + max) / 2;
                if (getLength(a) >= k) {
                    min = a;
                } else {
                    max = a;
                }
            }
            System.out.println("\nMax " + max);
        } catch (CustomException e) {
            System.out.println(e.toString());
        }
    }
}
