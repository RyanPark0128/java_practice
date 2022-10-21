import java.util.Arrays;

public class Quiz4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(top3(new int[] { 2, 3, 1 })));
        System.out.println(Arrays.toString(top3(new int[] { 2, 3, 1, 4, -5, 3, 13, 7, 2 })));
        System.out.println(Arrays.toString(top3(new int[] { -8, -12, 6, -7, -100 })));
        System.out.println(Arrays.toString(top3(new int[] { 4, 9 })));
        System.out.println(Arrays.toString(top3(new int[] { -40 })));
        System.out.println(Arrays.toString(top3(new int[] {})));
    }

    public static int[] top3(int[] array) {
        Arrays.sort(array);
        if (array.length > 2) {
            int[] answer = new int[] { 0, 0, 0 };
            answer[0] = array[array.length - 1];
            answer[1] = array[array.length - 2];
            answer[2] = array[array.length - 3];
            return answer;
        } else if (array.length > 1) {
            int[] answer = new int[] { 0, 0 };
            answer[0] = array[array.length - 1];
            answer[1] = array[array.length - 2];
            return answer;
        } else if (array.length == 1) {
            int[] answer = new int[] { 0 };
            answer[0] = array[array.length - 1];
            return answer;
        } else {
            return array;
        }
    }
}