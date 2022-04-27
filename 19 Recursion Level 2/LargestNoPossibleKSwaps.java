import java.util.*;

public class LargestNoPossibleKSwaps {

    static String max;

    public static void findMaximum(String str, int k) {
        // write your code here
        if (Integer.parseInt(str) > Integer.parseInt(max)) {
            max = str;
        }
        if (k == 0) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    String swapped = swap(str, i, j);
                    findMaximum(swapped, k - 1);
                    // swap(str, i, j);
                }
            }
        }

    }

    public static String swap(String str, int i, int j) {
        // char ith = str.charAt(i);
        // char jth = str.charAt(j);

        // String left = str.substring(0, i);
        // String middle = str.substring(i + 1, j);
        // String right = str.substring(j + 1);

        // return left + ith + middle + jth + right;
        StringBuilder sb = new StringBuilder(str);
        char ich = sb.charAt(i);
        char jch = sb.charAt(j);
        sb.setCharAt(j, ich);
        sb.setCharAt(i, jch);

        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            int k = scn.nextInt();
            max = str;
            findMaximum(str, k);
        }
        System.out.println(max);
    }

    // 2nd method
    // public static void findMaximum(char[] str,int k){
    // if(String.valueOf(str).compareTo(max)>0){
    // max=String.valueOf(str);
    // }

    // if(k==0){
    // return;
    // }

    // for (int i = 0; i < str.length; i++) {
    // for (int j = i+1; j < str.length; j++) {
    // if(str[i]<str[j]){
    // char t1=str[i];
    // str[i]=str[j];
    // str[j]=t1;
    // findMaximum(str, k-1);
    // char t2=str[i];
    // str[i]=str[j];
    // str[j]=t2;
    // }
    // }
    // }
    // }
    // public static void main(String[] args) {
    // try (Scanner scn = new Scanner(System.in)) {
    // String str = scn.next();
    // int k = scn.nextInt();
    // max = str;

    // findMaximum(str.toCharArray(),k);
    // }
    // System.out.println(max);
    // }

}
