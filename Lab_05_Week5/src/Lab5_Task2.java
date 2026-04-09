import java.util.Scanner;

public class Lab5_Task2 {
    public static void main(String[] args) {
        // Pseudocode:
        // Class Lab5_Task2
        // main()
        // int month
        // string trash
        // output "Enter you birth month: "
        // if int = valid
        // if month >= 1 && <= 12
        // output "Your birth month is: " + month
        // else
        // output "You entered an incorrect month value: " + month
        // else int != valid
        // output "Invalid input: " + trash
        // return
        // End main
        // End class

        Scanner in = new Scanner(System.in);
        int month = 0;
        String trash = "";

        System.out.print("Enter your birth month: ");

        if (in.hasNextInt()) {
            month = in.nextInt();
            in.nextLine();

            if (month >= 1 && month <= 12) {
                System.out.println("Your birth month is: " + month);
            } else {
                System.out.println("You entered an incorrect month value: " + month);
            }
        }
        else {
            trash = in.nextLine();
            System.out.println("Invalid input: " + trash);
        }
    }
}