import java.util.Scanner;

public class Lab5_Task1 {
    public static void main(String[] args) {
        // Pseudocode:
        // Class Lab5_Task1
        // main()
        // double price
        // double shipCost
        // double total
        // string trash
        // output "Enter the price of the item"
        // if price = valid
        // input price
        // if price >= 100 then
        // shipcost = 0
        // else
        // shipcost = price * 0.02
        // end if
        // total = price + shipcost
        // output "Shipping cost is " + shipcost
        // output "Total cost is " + total
        // else price != valid
        // output "Invalid input: " + trash
        // return
        // End main
        // End class

        Scanner in = new Scanner(System.in);
        double price = 0.0;
        double shipcost = 0.0;
        double total = 0.0;
        String trash = "";

        System.out.print("Enter the price of the item: ");

        if (in.hasNextDouble()) {
            price = in.nextDouble();
            in.nextLine();

            if (price >= 100) {
                shipcost = 0.0;
            } else {
                shipcost = price * 0.02;
            }

            total = price + shipcost;

            System.out.println("Shipping cost is " + shipcost);
            System.out.println("Total price is " + total);

        } else {
            trash = in.nextLine();
            System.out.println("Invalid input: " + trash);
        }
    }
}