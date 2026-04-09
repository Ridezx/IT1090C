import java.util.Scanner;

public class FavNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int favInt = SafeInput.getInt(in, "Enter your favorite integer: ");
        System.out.println("You entered integer: " + favInt);

        double favDouble = SafeInput.getDouble(in, "Enter your favorite double");
        System.out.println("You entered double: " + favDouble);
    }
}

