public class validPalindrome2 {

    // pepcoding
    public boolean validPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return checkPalndrome(str, i + 1, j) || checkPalndrome(str, i, j - 1);
        }
        return true;
    }

    public boolean checkPalndrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }

    // leetcode
    public boolean validPalindromeLeetcode(String s) {
        int n = s.length();
        byte[] a = s.getBytes();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (a[i] != a[j]) {
                return (func(a, i + 1, j) || func(a, i, j - 1));
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean func(byte[] a, int i, int j) {
        while (i < j) {
            if (a[i] != a[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
