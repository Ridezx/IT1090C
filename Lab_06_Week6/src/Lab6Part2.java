import java.util.Scanner;
public class Lab6Part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double gallons = 0;
        double mpg = 0;
        double pricepergallon = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("Enter number of gallons in the tank: ");
            if (in.hasNextDouble()) {
                gallons = in.nextDouble();
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
            System.out.print("Enter fuel efficiency: ");
            if (in.hasNextDouble()) {
                mpg = in.nextDouble();
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
            System.out.print("Enter price of gas per gallon: ");
            if (in.hasNextDouble()) {
                pricepergallon = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You said: " + trash);
                System.out.println("Please enter a valid number!");
            }
        } while (!done);

        double costfor100miles = (100.0 / mpg) * pricepergallon;
        double range = gallons * mpg;

        System.out.println("Cost to drive 100 miles: " + costfor100miles);
        System.out.println("The car can go this many miles on a full tank: " + range);

        in.close();
    }
}

