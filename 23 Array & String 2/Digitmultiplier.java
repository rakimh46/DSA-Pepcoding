public class Digitmultiplier {
    static String getSmallest(Long N) {
        // code here
        if (N < 10) {
            return N + "";
        }
        String ans = "";
        for (int i = 9; i > 1; i--) {
            while (N % i == 0) {
                ans = i + ans;
                N = N / i;
            }
        }
        return ans.length() == 0 || N != 1 ? "-1" : ans;
    }

    public static void main(String[] args) {
        long j = 26;
        System.out.println(getSmallest(j));
    }
}
