
//https://classroom.pepcoding.com/myClassroom/the-placement-program-pitampura-jan-15-2021/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion
import java.util.*;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(ClimbwithJumps(arr, n));
        }
    }

    public static int ClimbwithJumps(int[] arr, int n) {
        int[] dp = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            if (i == n) {
                dp[n] = 1;
            } else {
                int maxjump = arr[i];
                if (maxjump == 0) {
                    dp[i] = 0;
                } else {
                    for (int jump = 1; jump <= maxjump && jump+i<=n; jump++) {
                        dp[i] += dp[i + jump];
                    }
                }
            }
        }
        return dp[0];
    }
}
