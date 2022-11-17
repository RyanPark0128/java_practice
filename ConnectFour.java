import java.util.Scanner;

public class ConnectFour {
  public static void main(String[] args) {
    // First,initialize the game board with nested arrays with string values(6 by
    // 7), as well as the scanner
    String[][] board = new String[6][7];
    Scanner scan = new Scanner(System.in);

    // initialize and declare players into variables.
    String player1 = "R";
    String player2 = "Y";

    // Then, calls boardStatus method which displays the status of the gameboard.
    // This call will show players empty game board to start with.
    boardStatus(board);

    // Start the while loop to begin the game.
    while (true) {
      // Instruction message for players
      System.out.println("It is " + player1 + " players turn");
      System.out.println("Pick a column");

      // validInput method will validate the user input and will try to place the disk
      // using placeDisk method. If there are errors, the method will ask for new user
      // input until there aren't any errors
      validInput(scan, board, player1);

      // This boardStatus call will confirm the players with disc placement.
      boardStatus(board);

      // After each turn by a player, checkWinner method will be called to check if
      // there is a winner. If it finds winner, winner gets notified and exit the
      // while loop to end the game.
      if (checkWinner(board, player1)) {
        System.out.println(player1 + " Wins");
        break;
      }

      // Now, it is second player's turn. Same process with second player.
      System.out.println("It is " + player2 + " players turn");
      System.out.println("Pick a column");
      validInput(scan, board, player2);
      boardStatus(board);
      if (checkWinner(board, player2)) {
        System.out.println(player2 + " Wins");
        break;
      }
    }
    // if the game ends, closes the scanner and terminate.
    scan.close();
  }

  public static void boardStatus(String[][] board) {
    // This empty line is to make game board more visible
    System.out.println(" ");

    // nested loops are used to draw the game board. if the array value is null (not
    // declared), the loop will assign - value to it. Because no value is assigned
    // at the beginning, the board will start empty.
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

    // This loop is to add row which represent the column number at the bottom.
    for (int i = 0; i < board[0].length; i++) {
      System.out.print("|" + (i + 1));
    }
    System.out.println("|");
  }

  public static Boolean placeDisk(String[][] board, int column, String player) {
    // placeDisk method will try to place disk into the board. If the column is
    // full, it will return false asking user to select different column. Otherwise
    // it will place the disk and update the board array
    for (int i = 0; i < board.length; i++) {
      if (i == 0 && board[i][column - 1] != null) {
        return false;
      }
      // If the array item is not null (which means it has disk in that place), the
      // disk will be placed one row above it.
      else if (board[i][column - 1] != null) {
        board[i - 1][column - 1] = player;
        break;
      }
      // if there is nothing at the bottom of the gameboard, it will be placed with
      // the disk.
      else if (i == board.length - 1 && board[i][column - 1] == null) {
        board[i][column - 1] = player;
        break;
      }
    }
    return true;
  }

  public static Boolean checkWinner(String[][] board, String player) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (j > 2 && board[i][j] == player && board[i][j - 1] == player && board[i][j - 2] == player
            && board[i][j - 3] == player) {
          return true;
        } else if (j < 4 && board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
            && board[i][j + 3] == player) {
          return true;
        } else if (i > 2 && board[i][j] == player && board[i - 1][j] == player && board[i - 2][j] == player
            && board[i - 3][j] == player) {
          return true;
        } else if (i < 3 && board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
            && board[i + 3][j] == player) {
          return true;
        } else if (j > 2 && i > 2 && board[i][j] == player && board[i - 1][j - 1] == player
            && board[i - 2][j - 2] == player && board[i - 3][j - 3] == player) {
          return true;
          // up left
        } else if (j < 4 && i < 3 && board[i][j] == player && board[i + 1][j + 1] == player
            && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
          // down right
          return true;
        } else if (j < 4 && i > 2 && board[i][j] == player && board[i - 1][j + 1] == player
            && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
          // up right
          return true;
        } else if (j > 2 && i < 3 && board[i][j] == player && board[i + 1][j - 1] == player
            && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
          // down left
          return true;
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
          System.out.println("Pick a column");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please pick a number from 1 to 7");
        System.out.println("Pick a column");
      }
    }
  }
}