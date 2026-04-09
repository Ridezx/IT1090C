import java.util.Scanner;
public class Checkout {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double total = 0.0;
        boolean more = true;
        while (more) {
            double price = SafeInput.getRangedDouble(in, "Enter item price: ", 0.50, 10.00);
            total += price;
            more = SafeInput.getYNConfirm(in, "Do you have more items to scan?");
        }
        System.out.println("Total cost: $" + total);
    }
}

