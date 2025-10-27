import java.util.Random;
import java.util.Scanner;
public class Lab_09_ArrayStuff {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rnd = new Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        Scanner pipe = new Scanner(System.in);

        int userchoice = SafeInput.getRangedInt(pipe, "Enter an integer between 1 and 100", 1, 100);

        boolean found = false;
        int position = -1;

        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userchoice) {
                found = true;
                position = i;
                break;
            }
        }
        if (found) {
            System.out.println("The number " + userchoice + " was found at " + position);
        } else {
            System.out.println("The number " + userchoice + " was not found.");
        }
    }
}