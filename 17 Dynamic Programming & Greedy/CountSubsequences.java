//Count A+b+c+ Subsequences
public class CountSubsequences {
    public static void main(String[] args) {
        String str = "abcabc";
        subsequence(str);
    }

    public static void subsequence(String str) {
        int counta = 0, countab = 0, countabc = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                counta = (2 * counta) + 1;
            } else if (ch == 'b') {
                countab = (2 * countab) + counta;
            } else if (ch == 'c') {
                countabc = (2 * countabc) + countab;
            }
        }
        System.out.println(countabc);
    }
}
