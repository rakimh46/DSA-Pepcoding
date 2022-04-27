import java.util.*;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // write your code here
        for (int i = 1; i < 10; i++) {
            solve(i, n);
        }
    }

    public static void solve(int num, int n) {
        if (num > n) {
            return;
        }
        System.out.println(num);
        for (int digit = 0; digit < 10; digit++) {
            solve((num * 10) + digit, n);
        }
    }

}
