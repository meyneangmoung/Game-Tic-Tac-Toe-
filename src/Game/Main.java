package Game;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String[][] board = {
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}
    };

    static void showBoard() throws InterruptedException {
        for (String[] row : board) {
            for (String col : row) {
                Thread.sleep(100);
                System.out.print(col + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void playerMove(String player) {
        System.out.println("[+] Player (" + player + ")");
        while (true) {
            System.out.print("[+] Insert row (1-3): ");
            int r = scanner.nextInt();
            System.out.print("[+] Insert column (1-3): ");
            int c = scanner.nextInt();

            if (r < 1 || r > 3 || c < 1 || c > 3) {
                System.out.println("❌ Number must be from 1 to 3");
                continue;
            }

            if (!board[r - 1][c - 1].equals("-")) {
                System.out.println("❌ This position is already used");
                continue;
            }

            board[r - 1][c - 1] = player;
            break;
        }
    }

    static boolean isWinner(String player) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) &&
                    board[i][1].equals(player) &&
                    board[i][2].equals(player)) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(player) &&
                    board[1][i].equals(player) &&
                    board[2][i].equals(player)) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player)) {
            return true;
        }

        if (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
    }

    static void playGame() throws InterruptedException {
        while (true) {

            showBoard();
            playerMove("X");

            if (isWinner("X")) {
                showBoard();
                System.out.println("🎉 Winner is Player X!");
                return;
            }

            if (isFull()) {
                showBoard();
                System.out.println("🤝 Draw!");
                return;
            }

            showBoard();
            playerMove("O");

            if (isWinner("O")) {
                showBoard();
                System.out.println("🎉 Winner is Player O!");
                return;
            }

            if (isFull()) {
                showBoard();
                System.out.println("🤝 Draw!");
                return;
            }
        }
    }

    static void welcome() throws InterruptedException {
        String text = "Welcome to Tic Tac Toe Game v2.0";
        for (char c : text.toCharArray()) {
            Thread.sleep(40);
            System.out.print(c);
        }
        System.out.println("\nPlayers: X and O\n");
    }

    public static void main(String[] args) throws Exception {

        while (true) {
            welcome();
            playGame();

            System.out.print("Play again? (y/n): ");
            String choice = scanner.next().toLowerCase();


            if (choice.equals("y")) {
                resetBoard();
            } else {
                System.out.println("👋 Have a nice day!");
                break;
            }
        }
    }
}

