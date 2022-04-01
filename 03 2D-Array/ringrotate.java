public class ringrotate {
    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13, 14 },
                        { 21, 22, 23, 24 },
                        { 31, 32, 33, 34 },
                        { 41, 42, 43, 44 } };

        int s = 2; // shell
        int r = 1; // rotate

        int[] oned = filloned(arr, s);

        rotate(oned, r);
        fillback(oned, arr, s);
        display(arr);
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    public static void rotate(int[] oned,int r) {
        if(r<0){
            r=oned.length+r;
        }

        reverse(oned, 0, oned.length-1);
        reverse(oned, 0, r-1);
        reverse(oned, r, oned.length-1);
        
        
    }

    public static void reverse(int[] oned,int si,int ei) {
        while(si<ei){
            int temp=oned[si];
            oned[si]=oned[ei];
            oned[ei]=temp;
            si++;
            ei--;
        }
    }

    public static int[] filloned(int[][] arr, int s) {

        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        // size of oned array is left wall(lw) + right wall(bw) +up wall(uw) + down
        // wall(dw)
        int size = 2 * (maxr - minr + maxc - minc);

        int[] oned = new int[size];
        int idx = 0;

        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        minc++;

        for (int i = maxr, j = minc; j <= maxc; j++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        maxr--;

        for (int i = maxr, j = maxc; i >= minr; i--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        maxc--;

        for (int i = minr, j = maxc; j >= minc; j--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        return oned;
    }

    public static void fillback(int[] oned,int[][] arr,int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        int idx=0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            arr[i][j]=oned[idx];
            idx++;
        }
        minc++;

        for (int i = maxr, j = minc; j <= maxc; j++) {
            arr[i][j]=oned[idx];
            idx++;
        }
        maxr--;

        for (int i = maxr, j = maxc; i >= minr; i--) {
            arr[i][j]=oned[idx];
            idx++;
        }
        maxc--;

        for (int i = minr, j = maxc; j >= minc; j--) {
            arr[i][j]=oned[idx];
            idx++;
        }
        
    }

}
