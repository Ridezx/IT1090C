import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.length() == 0) {
                System.out.println("Input cannot be blank!");
            }
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int rval = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                rval = pipe.nextInt();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Not a good integer: " + trash + ". Please listen to me.");
            }
            pipe.nextLine();
        } while (!valid);
        return rval;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double rval = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                rval = pipe.nextDouble();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Not a good integer: " + trash + ". Please listen to me.");
            }
            pipe.nextLine();
        } while (!valid);
        return rval;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int rval = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                rval = pipe.nextInt();
                if (rval >= low && rval <= high) {
                    valid = true;
                } else {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Not a good integer: " + trash + ". Please listen to me.");
            }
            pipe.nextLine();
        } while (!valid);
        return rval;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double rval = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                rval = pipe.nextDouble();
                if (rval >= low && rval <= high) {
                    valid = true;
                } else {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a number.");
            }
            pipe.nextLine();
        } while (!valid);
        return rval;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;
        boolean rval = false;
        do {
            System.out.print(prompt + " (Y/N): ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                rval = true;
                valid = true;
            } else if (response.equalsIgnoreCase("N")) {
                rval = false;
                valid = true;
            } else {
                System.out.println("Is that number Y or N....No, its not. How do you fail at this?");
            }
        } while (!valid);
        return rval;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean valid = false;
        do {
            System.out.print(prompt);
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("That does not match the pattern.");
            }
        } while (!valid);
        return response;
    }

    public static void prettyHeader(String msg)
    {
        final int total_width = 60;
        final int borderstars = 3;

        for (int i = 0; i < total_width; i++) {
            System.out.print("*");
        }
        System.out.println();

        int msgLength = msg.length();
        int spaceAvailable = total_width - (borderstars * 2) - msgLength;
        int paddingLeft = spaceAvailable / 2;
        int paddingRight = spaceAvailable - paddingLeft;

        System.out.print("***");
        for (int i = 0; i < paddingLeft; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingRight; i++) {
            System.out.print(" ");
        }
        System.out.println("***");
        for (int i = 0; i < total_width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}