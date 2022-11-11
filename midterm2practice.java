import java.util.Arrays;

public class midterm2practice {
  public static void main(String[] args) {
    // int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14,
    // 15 }, { 16, 17, 18, 19, 20 },
    // { 21, 22, 23, 24, 25 } };
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[i].length; j++) {
    // if (i > j) {
    // int temp = matrix[j][i];
    // matrix[j][i] = matrix[i][j];
    // matrix[i][j] = temp;
    // }
    // }
    // }

    // for (int i = 0; i < matrix.length; i++) {
    // System.out.println(Arrays.toString(matrix[i]));
    // }
    int num = 278;
    String converted = "";
    while (num != 0) {
      converted = String.valueOf(num % 8) + converted;
      num = num / 8;
    }

    System.out.println(converted);
  }
}
