import java.util.Scanner;
import java.util.Random;
public class Lab6Part4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();

        int secret = gen.nextInt(10) + 1;
        int guess = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("Guess a number between 1 and 10: ");
            if (in.hasNextInt()) {
                guess = in.nextInt();
                in.nextLine();

                if (guess >= 1 && guess <= 10) {
                    done = true;
                } else {
                    System.out.println("Reading comprehension isn't your strong suit. 1-10...");
                }
            } else {
                trash = in.nextLine();
                System.out.println("You said: " + trash);
                System.out.println("That's not even a number man...");
            }
        } while (!done);

        System.out.println("The random number was: " + secret);

        if (guess < secret) {
            System.out.println("Your guess was too low.");
        } else if (guess > secret) {
            System.out.println("Your guess was too high.");
        } else {
            System.out.println("Sheer dumb luck. No way you can do it again.");
        }

        in.close();
    }
}
