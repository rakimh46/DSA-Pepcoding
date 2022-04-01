import java.util.ArrayList;
import java.util.List;

public class SpiralDisplay {
    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13, 14 },
                { 21, 22, 23, 24 },
                { 31, 32, 33, 34 },
                { 41, 42, 43, 44 } };
        int minr = 0, minc = 0, maxr = arr.length - 1, maxc = arr[0].length - 1;
        int t=arr.length*arr[0].length;  // total element in array
        int count=0;
        List<Integer> ans=new ArrayList<Integer>();
        while (count<t) {
            for (int i = minr, j = minc; i <= maxr && count<t; i++) {
                //System.out.print(arr[i][j]);
                ans.add(arr[i][j]);
                count++;
            }
            minc++;

            for (int i = maxr, j = minc; j <= maxc && count<t; j++) {
                //System.out.print(arr[i][j]);
                ans.add(arr[i][j]);
                count++;
            }
            maxr--;

            for (int i = maxr, j = maxc; i >= minr && count<t; i--) {
                //System.out.print(arr[i][j]);
                ans.add(arr[i][j]);
                count++;
            }
            maxc--;

            for (int i = minr, j = maxc; j >= minc && count<t; j--) {
                //System.out.print(arr[i][j]);
                ans.add(arr[i][j]);
                count++;
            }
            minr++;
        }
        System.out.println(ans);
    }

}
