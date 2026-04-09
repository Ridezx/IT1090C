import java.util.Scanner;

public class Lab5_Task3 {
    public static void main(String[] args) {
        // Pseudocode:
        // Class Lab5_Task3
        // main()
        // string choice
        // string = string in uppercase
        // output "Enter your party: "
        // if choice = D
        // output "You get a Democratic Donkey"
        // else if choice = R
        // output "You get a Republican Elephant."
        // else if choice = I
        // output "You get an Independent Person."
        // else
        // output "You are something else. I don't know what your symbol is."
        // return
        // End main
        // End class

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your party affiliation:\nD = Democrat.\nR = Republican.\nI = Independent.");
        System.out.print("Your choice: ");

        String choice = in.nextLine();
        choice = choice.toUpperCase();

        if (choice.equals("D")) {
            System.out.println("You get a democratic donkey.");
        } else if (choice.equals("R")) {
            System.out.println("You get a republican elephant.");
        } else if (choice.equals("I")) {
            System.out.println("You get an independent person.");
        } else {
            System.out.println("You are something else. Idk what your symbol is.");
        }
    }
}
