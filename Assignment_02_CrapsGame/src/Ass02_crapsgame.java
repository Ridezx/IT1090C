import java.util.Scanner;
public class Ass02_crapsgame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("You have no choice. Play the game.");

        while (playAgain) {
            System.out.print("Enter your first die (1-6): ");
            int die1 = input.nextInt();
            
            System.out.print("Enter your second die (1-6): ");
            int die2 = input.nextInt();

            int sum = die1 + die2;
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum + ": But did you really roll that?");

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You had a 16.7% chance of losing. You still managed to lose, loser.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You win, even though you put in the numbers. I severely doubt that you grabbed dice for this game, so did you really win anything? Anyway you're technically a 'natural.'");
            } else {
                int point = sum;
                System.out.println("You didn't win or lose. You just exist. But what does it mean to exist? Anyways, the point is now: " + point);
                boolean rolling = true;

                while (rolling) {
                    System.out.print("Roll again - enter your first die (1-6): ");
                    die1 = input.nextInt();

                    System.out.print("Enter your second die (1-6): ");
                    die2 = input.nextInt();

                    sum = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum + ": But did you really roll that again?");

                    if (sum == point) {
                        System.out.println("You won, still a loser in my heart tho.");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("A seven. You lost, loser.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Would you like to play again?: ");
            String answer = input.next();
            if (!answer.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }
    }
}
