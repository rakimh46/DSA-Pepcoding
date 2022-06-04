
import java.io.*;

class BooleanParenthesization {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends

class Solution {
    static int m = 1003;

    static class Pair {
        int tc;
        int fc;

        Pair(int tc, int fc) {
            this.tc = tc;
            this.fc = fc;
        }
    }

    static int countWays(int N, String S) {
        // code here
        String s1 = ""; // operands
        String s2 = ""; // operator

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == 'T' || ch == 'F') {
                s1 += ch;
            } else {
                s2 += ch;
            }
        }

        Pair[][] dp = new Pair[s1.length()][s1.length()];

        for (int d = 0; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp.length; i++, j++) {
                if (d == 0) {
                    int tc = s1.charAt(i) == 'T' ? 1 : 0;
                    int fc = tc == 1 ? 0 : 1;

                    dp[i][j] = new Pair(tc, fc);
                } else if (d == 1) {
                    boolean op1 = s1.charAt(i) == 'T' ? true : false;
                    boolean op2 = s1.charAt(j) == 'T' ? true : false;
                    char opr = s2.charAt(i);

                    dp[i][j] = calculate(op1, op2, opr);
                } else {
                    int tc = 0;
                    int fc = 0;

                    for (int k = i; k < j; k++) {

                        Pair lans = dp[i][k];
                        Pair rans = dp[k + 1][j];

                        Pair ans = helper(lans, rans, s2.charAt(k));
                        tc += ans.tc;
                        fc += ans.fc;
                    }
                    dp[i][j] = new Pair(tc % m, fc % m);
                }
            }
        }

        Pair ans = dp[0][dp[0].length - 1];
        return ans.tc % m;
    }

    static Pair calculate(boolean op1, boolean op2, char opr) {
        boolean res = false;

        if (opr == '|') {
            res = op1 | op2;
        } else if (opr == '&') {
            res = op1 & op2;
        } else {
            res = op1 ^ op2;
        }

        if (res == true) {
            return new Pair(1, 0);
        } else {
            return new Pair(0, 1);
        }
    }

    public static Pair helper(Pair lans,Pair rans,char opr) {
        int lt = lans.tc;
        int lf = lans.fc;
        int rt = rans.tc;
        int rf = rans.fc;
        
        int tc = 0;
        int fc = 0;
        
        if(opr == '|') {
            tc = lt * rt + lt * rf + lf * rt;
            fc = lf * rf;
        }
        else if(opr == '&') {
            tc = lt * rt;
            fc = lt * rf + lf * rt + lf * rf;
        }
        else {
            tc = lt * rf + lf * rt;
            fc = lt * rt + lf * rf;
        }
        
        return new Pair(tc%m,fc%m);
    }
}