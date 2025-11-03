import java.util.Scanner;

public class TicTacToe {
    private static final int num_rows = 3;
    private static final int num_cols = 3;
    private static String[][] board = new String[num_rows][num_cols];
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean play_again;

        do {
            clearBoard();
            String player = "X";
            boolean game_over = false;
            int move_count = 0;

            while (!game_over) {
                display();
                int row_move = SafeInput.getRangedInt(in, player + " - Enter your row", 1, 3) - 1;
                int col_move = SafeInput.getRangedInt(in, player + " - Enter your column", 1, 3) - 1;

                while (!isValidMove(row_move, col_move)) {
                    System.out.println("That spot is already taken! Try again.");
                    row_move = SafeInput.getRangedInt(in, player + " - Enter your row", 1, 3) - 1;
                    col_move = SafeInput.getRangedInt(in, player + " - Enter your column", 1, 3) - 1;
                }
                board[row_move][col_move] = player;
                move_count++;

                if (move_count >= 5 && isWin(player)) {
                    display();
                    System.out.println("Player " + player + " is better. They're just like that.");
                    game_over = true;
                } else if (move_count == 9 || isTie()) {
                    display();
                    System.out.println("You tied. That makes you both losers in my books.");
                    game_over = true;
                } else {
                    if (player.equals("X")) {
                        player = "O";
                    } else {
                        player = "X";
                    }
                }
            }
            play_again = SafeInput.getYNConfirm(in, "Do you want to play again?");}
        while (play_again);
    }


    private static void clearBoard() {
        for (int r = 0; r < num_rows; r++) {
            for (int c = 0; c < num_cols; c++) {
                board[r][c] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("  1   2   3");
        for (int r = 0; r < num_rows; r++) {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < num_cols; c++) {
                System.out.print(board[r][c]);
                if (c < num_cols - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (r < num_rows - 1) {
                System.out.println(" -----------");
            }
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r < num_rows; r++) {
            if (board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int c = 0; c < num_cols; c++) {
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isTie() {
        for (int r = 0; r < num_rows; r++) {
            for (int c = 0; c < num_cols; c++) {
                if (board[r][c].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}