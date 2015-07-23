package by.intexsoft.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Admin on 21.07.2015.
 */
public class Main {

    private static ArrayList<File> fileList = new ArrayList<>();

    public static void getFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                fileList.add(s);
            }
        }
    }

    public static void main(String[] args) {
        getFiles("D:\\Неизвестная папка");

        Collections.sort(fileList, (o1, o2) ->
            o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase())
        );

        try (FileWriter writer = new FileWriter(new File("output.txt"))) {
            for (File fil : fileList) {
                writer.write("name: " + fil.getName() + " " + " size: " + fil.length() + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
