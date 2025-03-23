import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    private static char[][] board = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        initializeBoard();
        boolean isPlayerOneTurn = true;
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            int column = getPlayerMove(isPlayerOneTurn);
            if (dropDisc(column, isPlayerOneTurn ? PLAYER_ONE : PLAYER_TWO)) {
                gameWon = checkWin();
                isPlayerOneTurn = !isPlayerOneTurn;
            } else {
                System.out.println("Column full! Try again.");
            }
        }

        printBoard();
        System.out.println("Player " + (isPlayerOneTurn ? "Two" : "One") + " wins!");
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
        System.out.println(" 1 2 3 4 5 6 7");
    }

    private static int getPlayerMove(boolean isPlayerOneTurn) {
        Scanner scanner = new Scanner(System.in);
        int column;
        while (true) {
            System.out.print("Player " + (isPlayerOneTurn ? "One (X)" : "Two (O)") + ", choose a column (1-7): ");
            column = scanner.nextInt() - 1;
            if (column >= 0 && column < COLUMNS) {
                return column;
            }
            System.out.println("Invalid column. Choose between 1 and 7.");
        }
    }

    private static boolean dropDisc(int column, char playerDisc) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = playerDisc;
                return true;
            }
        }
        return false;
    }

    private static boolean checkWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                char cell = board[row][col];
                if (cell == EMPTY) continue;

                if (col + 3 < COLUMNS && cell == board[row][col + 1] && cell == board[row][col + 2] && cell == board[row][col + 3])
                    return true; // Horizontal win

                if (row + 3 < ROWS && cell == board[row + 1][col] && cell == board[row + 2][col] && cell == board[row + 3][col])
                    return true; // Vertical win

                if (row + 3 < ROWS && col + 3 < COLUMNS && cell == board[row + 1][col + 1] && cell == board[row + 2][col + 2] && cell == board[row + 3][col + 3])
                    return true; // Diagonal (\) win

                if (row + 3 < ROWS && col - 3 >= 0 && cell == board[row + 1][col - 1] && cell == board[row + 2][col - 2] && cell == board[row + 3][col - 3])
                    return true; // Diagonal (/) win
            }
        }
        return false;
    }
}
