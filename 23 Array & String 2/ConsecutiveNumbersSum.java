public class ConsecutiveNumbersSum {

    // leetcode
    public static int ConsecutiveNumbersSumCount(int n) {
        int count = 0, i = 1;
        while (n > 0) {
            n -= i;
            if (n % i == 0)
                count++;
            i++;
        }

        return count;
    }

    // pepcoding
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) < 2 * n; k++) {
            int numerator = n - (k * (k - 1) / 2);
            if (numerator % k == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int val = ConsecutiveNumbersSumCount(15);
        System.out.println(val);
    }
}
