import java.util.Scanner;
import java.util.Random;

public class ConnectFour2 {
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

      // This boardStatus call will confirm the players with disc placement. If the
      // game board is full without a winner it will end the game with message
      if (!boardStatus(board) && !checkWinner(board, player1)) {
        System.out.println("Game board is full! Draw!");
        break;
      }

      // After each turn by a player, checkWinner method will be called to check if
      // there is a winner. If it finds winner, winner gets notified and exit the
      // while loop to end the game.
      else if (checkWinner(board, player1)) {
        System.out.println(player1 + " Wins");
        break;
      }

      // Now, it is AI's turn. Instead of getting inputs from user the A.I will:
      // 1) take the win if it can
      // 2) blocks user if user is about to win
      // 3) otherwise, randomly place the disk.
      System.out.println("It is " + player2 + " players turn");
      System.out.println("Pick a column");

      // This function call will check possible win move for A.I, and A.I will place
      // disk to win.
      if (possibleMove(board, player2) > 0) {
        placeDisk(board, possibleMove(board, player2) + 1, player2);
      }
      // This function call will check possible win move for player and A.I will place
      // disk to block users disk.
      else if (possibleMove(board, player1) > 0) {
        placeDisk(board, possibleMove(board, player1) + 1, player2);
      }
      // Otherwise it will generate random number and place disk accordingly. If the
      // column is full it will generate another random value until it finds column
      // that is not full
      else {
        while (true) {
          Random rand = new Random();
          if (placeDisk(board, rand.nextInt(7) + 1, player2)) {
            break;
          }
        }
      }

      // If the board is full without a winner, the program will alert user and end
      // the game.
      if (!boardStatus(board) && !checkWinner(board, player2)) {
        System.out.println("Game board is full! Draw!");
        break;
      }

      // If there is a winner, game ends.
      else if (checkWinner(board, player2)) {
        System.out.println(player2 + " Wins");
        break;
      }

    }
    // if the game ends, closes the scanner and terminate.
    scan.close();
  }

  public static int possibleMove(String[][] board, String player) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        // possible win move for bottom direction
        if (i < 3 && board[i][j] == null && board[i + 1][j] == player && board[i + 2][j] == player
            && board[i + 3][j] == player) {
          return j;
        }

        // possible win move for left direction
        if (j > 2 && (i == board.length - 1 || board[i + 1][j] != null) && board[i][j] == null
            && board[i][j - 1] == player && board[i][j - 2] == player && board[i][j - 3] == player) {
          return j;
        }
        // possible win move for right direction
        if (j < 4 && (i == board.length - 1 || board[i + 1][j] != null) && board[i][j] == null
            && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
          return j;
        }

        // possible win move for bottom right direction
        if (j < 4 && i < 3 && board[i + 1][j] != null && board[i][j] == null && board[i + 1][j + 1] == player
            && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
          return j;
        }
        // possible win move for bottom left direction
        if (j > 2 && i < 3 && board[i + 1][j] != null && board[i][j] == null && board[i + 1][j - 1] == player
            && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
          return j;
        }
        // possible win move for top left direction
        if (j > 2 && i > 2 && (i == board.length - 1 || board[i + 1][j] != null) && board[i][j] == null
            && board[i - 1][j - 1] == player && board[i - 2][j - 2] == player && board[i - 3][j - 3] == player) {
          return j;
        }
        // possible win move for top right direction
        if (j < 4 && i > 2 && (i == board.length - 1 || board[i + 1][j] != null) && board[i][j] == null
            && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
          return j;
        }
        //
      }
    }
    return -1;
  }

  public static Boolean boardStatus(String[][] board) {
    // This empty line is to make game board more visible
    System.out.println(" ");
    // create count variable to check wheter the game board is full or not
    int count = 0;
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
          count += 1;
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

    // if the board is full, returns false else returns true
    return count == 42 ? false : true;
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
    // This method will check if there is winner or not. For each instance in the
    // nested loop (gameboard), it will check if there are 4 same consecutive disks
    // in the horizontal(right, left), vertical(top, bottom), and diagnol directions
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        // This will check 4 consecutive matching disks to the left. j should be bigger
        // than 2 to prevent going out of bounds.
        if (j > 2 && board[i][j] == player && board[i][j - 1] == player && board[i][j - 2] == player
            && board[i][j - 3] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the right. j should be
        // smaller than 4 to prevent going out of bounds.
        else if (j < 4 && board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
            && board[i][j + 3] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the top. i should be bigger
        // than 2 to prevent going out of bounds.
        else if (i > 2 && board[i][j] == player && board[i - 1][j] == player && board[i - 2][j] == player
            && board[i - 3][j] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the bottom. i should be
        // smaller than 3 to prevent going out of bounds.
        else if (i < 3 && board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
            && board[i + 3][j] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the top left. i should be
        // bigger than 2 and j should be bigger than 2 to prevent going out of bounds.
        else if (j > 2 && i > 2 && board[i][j] == player && board[i - 1][j - 1] == player
            && board[i - 2][j - 2] == player && board[i - 3][j - 3] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the bottom right. i should be
        // less than 3 and j should be less than 4 to prevent going out of bounds.
        else if (j < 4 && i < 3 && board[i][j] == player && board[i + 1][j + 1] == player
            && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the top right. i should be
        // bigger than 2 and j should be less than 4 to prevent going out of bounds.
        else if (j < 4 && i > 2 && board[i][j] == player && board[i - 1][j + 1] == player
            && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
          return true;
        }
        // This will check 4 consecutive matching disks to the bottom left. i should be
        // less than 3 and j should be bigger than 2 to prevent going out of bounds.
        else if (j > 2 && i < 3 && board[i][j] == player && board[i + 1][j - 1] == player
            && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
          return true;
        }
      }
    }
    return false;
  }

  public static void validInput(Scanner scan, String[][] board, String player) {
    // The while loop will continue to validate user input until it gets right user
    // input
    while (true) {
      // to handle the NumberFormatException, try and catch was implemented
      try {
        int num = Integer.parseInt(scan.nextLine());
        // Validates the number range from 1 to 7
        if (num < 1 || num > 7) {
          System.out.println("Please pick a number from 1 to 7");
          System.out.println("Pick a column");
        } else {
          // if the placeDisk returns with false(which means that the disk is full), show
          // message to players and ask for different input. Otherwise break the while
          // loop since it means that the disk is placed.
          if (!placeDisk(board, num, player)) {
            System.out.println("Column is full");
            System.out.println("Pick a column");
          } else {
            break;
          }
        }
        // The catch will handle the NumberFormatException
      } catch (NumberFormatException e) {
        System.out.println("Please pick a number from 1 to 7");
        System.out.println("Pick a column");
      }
    }
  }
}