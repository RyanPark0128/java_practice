import java.util.Scanner;

public class ConnectFour {
  public static void main(String[] args) {
    String[][] board = new String[6][7];
    Scanner scan = new Scanner(System.in);
    String player1 = "R";
    String player2 = "Y";
    boardStatus(board);
    while (true) {
      System.out.println("It is " + player1 + " players turn");
      System.out.println("Pick a column");
      validInput(scan, board, player1);
      boardStatus(board);
      if (checkWinner(board, player1)) {
        System.out.println(player1 + " Wins");
        break;
      }

      System.out.println("It is " + player2 + " players turn");
      System.out.println("Pick a column");
      validInput(scan, board, player2);
      boardStatus(board);
      if (checkWinner(board, player2)) {
        System.out.println(player2 + " Wins");
        break;
      }
    }

    scan.close();
  }

  public static void boardStatus(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        String temp = "";
        if (board[i][j] == null) {
          temp = "-";
        } else {
          temp = board[i][j];
        }
        System.out.print("|" + temp);
      }
      System.out.println("|");
    }
    for (int i = 0; i < board[0].length; i++) {
      System.out.print("|" + (i + 1));
    }
    System.out.println("|");
  }

  public static Boolean placeDisk(String[][] board, int column, String player) {
    for (int i = 0; i < board.length; i++) {
      if (i == 0 && board[i][column - 1] != null) {
        return false;
      } else if (board[i][column - 1] != null) {
        board[i - 1][column - 1] = player;
        break;
      } else if (i == board.length - 1 && board[i][column - 1] == null) {
        board[i][column - 1] = player;
        break;
      }
    }
    return true;
  }

  public static Boolean checkWinner(String[][] board, String player) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (j > 2) {
          if (board[i][j] == player && board[i][j - 1] == player && board[i][j - 2] == player
              && board[i][j - 3] == player) {
            return true;
          }
        }
        if (j < 4) {
          if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
              && board[i][j + 3] == player) {
            return true;
          }
        }

        if (i > 2) {
          if (board[i][j] == player && board[i - 1][j] == player && board[i - 2][j] == player
              && board[i - 3][j] == player) {
            return true;
          }
        }

        if (i < 3) {
          if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
              && board[i + 3][j] == player) {
            return true;
          }
        }

        if (j > 2 && i > 2) {
          if (board[i][j] == player && board[i - 1][j - 1] == player && board[i - 2][j - 2] == player
              && board[i - 3][j - 3] == player) {
            return true;
          }

          // up left
        }

        if (j < 4 && i < 3) {

          // down right
          if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
              && board[i + 3][j + 3] == player) {
            return true;
          }
        }

        if (j < 4 && i > 2) {
          // up right
          if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player
              && board[i - 3][j + 3] == player) {
            return true;
          }
        }

        if (j > 2 && i < 3) {
          // down left
          if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player
              && board[i + 3][j - 3] == player) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void validInput(Scanner scan, String[][] board, String player) {
    while (true) {
      try {
        int num = Integer.parseInt(scan.nextLine());
        if (num > 0 && num < 8) {
          if (!placeDisk(board, num, player)) {
            System.out.println("Column is full");
            System.out.println("Pick a column");
          } else {
            break;
          }
        } else {
          System.out.println("Please pick a number from 1 to 7");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please pick a number from 1 to 7");
      }
    }
  }
}