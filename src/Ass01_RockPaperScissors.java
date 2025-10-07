import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String playerA;
        String playerB;
        String playAgain = "Y";

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (playAgain.equalsIgnoreCase("Y")) {

            System.out.print("Player A, enter your move. R, P, or S: ");
            playerA = input.nextLine();

            while (!playerA.equalsIgnoreCase("R") &&
                    !playerA.equalsIgnoreCase("P") &&
                    !playerA.equalsIgnoreCase("S")) {
                System.out.print("I literally told you what to click, how do you fail at this? Try again. R, P, or S: ");
                playerA = input.nextLine();
            }

            System.out.print("Player B, enter your move (R, P, S): ");
            playerB = input.nextLine();

            while (!playerB.equalsIgnoreCase("R") &&
                    !playerB.equalsIgnoreCase("P") &&
                    !playerB.equalsIgnoreCase("S")) {
                System.out.print("I literally told you what to click, how do you fail at this? Try again. R, P, or S: ");
                playerB = input.nextLine();
            }

            if (playerA.equalsIgnoreCase(playerB)) {
                System.out.println("You tied.");
            } else if (playerA.equalsIgnoreCase("R") && playerB.equalsIgnoreCase("S")) {
                System.out.println("Rock obliterates scissors – Player A lives");
            } else if (playerA.equalsIgnoreCase("S") && playerB.equalsIgnoreCase("P")) {
                System.out.println("Scissors eviscerates paper – Player A has to pick up paper pieces");
            } else if (playerA.equalsIgnoreCase("P") && playerB.equalsIgnoreCase("R")) {
                System.out.println("Paper somehow blinds rock – Player A somehow wins");
            } else if (playerB.equalsIgnoreCase("R") && playerA.equalsIgnoreCase("S")) {
                System.out.println("Rock obliterates scissors – Player B lives");
            } else if (playerB.equalsIgnoreCase("S") && playerA.equalsIgnoreCase("P")) {
                System.out.println("Scissors eviscerates paper – Player B has to pick up paper pieces");
            } else if (playerB.equalsIgnoreCase("P") && playerA.equalsIgnoreCase("R")) {
                System.out.println("Paper somehow blinds rock – Player B somehow wins");
            }

            System.out.print("Endless loop of death? (Y/N): ");
            playAgain = input.nextLine();
        }

        System.out.println("I thought we were gonna die together in this loop. I TRUSTED YOU. HOW DARE YOU LEAVE ME. I DON'T WANNA GO BACK TO BEING ALONE");
        input.close();
    }
}

