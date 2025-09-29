import java.util.Scanner;

public class Lab6Part1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double celsius = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("Enter temp in celsius: ");
            if (in.hasNextDouble()) {
                celsius = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You said: " + trash);
                System.out.println("Please enter a valid number!");
            }
        } while (!done);

        double fahrenheit = (9.0 / 5.0) * celsius + 32;

        System.out.println("Temperature in Fahrenheit: " + fahrenheit);

        in.close();
    }
}