import java.util.Scanner;
public class Lab6Part3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double width = 0;
        double height = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("Enter the width of the rectangle: ");
            if (in.hasNextDouble()) {
                width = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You said: " + trash);
                System.out.println("Please enter a valid number!");
            }
        } while (!done);

        done = false;
        do {
            System.out.print("Enter the height of the rectangle: ");
            if (in.hasNextDouble()) {
                height = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You said: " + trash);
                System.out.println("Please enter a valid number!");
            }
        } while (!done);

        double area = width * height;
        double perimeter = 2 * (width + height);
        double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Diagonal: " + diagonal);

        in.close();
    }
}
