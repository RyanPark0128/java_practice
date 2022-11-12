public class ConnectFour {
  public static void main(String[] args) {
    String[][] board = new String[6][7];

    // while (true) {
    boardStatus(board);
    // }
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
}