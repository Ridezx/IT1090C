import java.util.Scanner;

public class Lab5_Task4 {
    public static void main(String[] args) {
        // Class Lab5_Task4
        // main()
        // int age
        // string trash
        // output "Enter your age: "
        // if age = valid
        // if age >= 21
        // output "You get a wristband"
        // else
        // output "Invalid input: " + trash
        // return
        // End main
        // End class

        Scanner in = new Scanner(System.in);
        int age = 0;
        String trash = "";

        System.out.print("Enter your age: ");

        if (in.hasNextInt()) {
            age = in.nextInt();
            in.nextLine();

            if (age >= 21) {
                System.out.println("You get a wristband.");
            }

        } else {
            trash = in.nextLine();
            System.out.println("Invalid input: " + trash);
        }
    }
}
