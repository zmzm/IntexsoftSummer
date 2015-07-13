package by.intexsoft.graph;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Admin on 13.07.2015.
 */
public class Main {
    private int n;
    private int m;
    private ArrayList<Integer> adj[];
    private boolean used[];

    private PrintWriter p;
    Scanner in = new Scanner(System.in);

    private void dfs(int v) {
        if (used[v]) {
            return;
        }
        used[v] = true;
        p.print((v + 1) + " ");
        for (int i = 0; i < adj[v].size(); ++i) {
            int w = adj[v].get(i);
            dfs(w);
        }
    }

    private void getData() throws IOException {
        p = new PrintWriter(System.out);

        System.out.println("Введите количество вершин: ");
        n = in.nextInt();
        System.out.println("Введите количество ребер: ");
        m = in.nextInt();

        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; ++i) {
            System.out.println("Введите ребро: ");
            int v = in.nextInt();
            int w = in.nextInt();
            v--;
            w--;
            adj[v].add(w);
            adj[w].add(v);
        }

        used = new boolean[n];
        Arrays.fill(used, false);
    }

    private void start() throws IOException {
        getData();
        System.out.println("Обход графа: ");
        for (int v = 0; v < n; ++v) {
            dfs(v);
        }
        p.close();
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.start();
    }
}
