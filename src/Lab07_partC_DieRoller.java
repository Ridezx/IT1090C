import java.util.Random;
import java.util.Scanner;

public class Lab07_partC_DieRoller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Roll\tDie1\tDie2\tDie3\tSum\n--------------------------------------------");

            int rollCount = 0;
            int die1, die2, die3, sum;

            do {
                rollCount++;
                die1 = rand.nextInt(6) + 1;
                die2 = rand.nextInt(6) + 1;
                die3 = rand.nextInt(6) + 1;
                sum = die1 + die2 + die3;

                System.out.println(rollCount + "\t" + die1 + "\t" + die2 + "\t" + die3 + "\t" + sum);

            } while (!(die1 == die2 && die2 == die3));

            System.out.println("Triple rolled. All dice show " + die1);

            System.out.print("Roll again? (y/n): ");
            String response = input.next();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }
    }
}