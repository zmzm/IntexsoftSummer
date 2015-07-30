package by.intexsoft.rectangle;

public class Main {

    public static void main(String[] args) {

        try {
            Rectangle rect = new Rectangle(10, 20, 100, 200);
            rect.draw();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }
}
