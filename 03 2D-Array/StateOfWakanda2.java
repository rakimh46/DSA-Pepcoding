public class StateOfWakanda2 {
    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13, 14 }, 
                        { 21, 22, 23, 24 }, 
                        { 31, 32, 33, 34 }, 
                        { 41, 42, 43, 44 } };

        // gap is diffrence of i and j 

        for (int  gap= 0; gap < arr.length; gap++) {
            for(int  i=0,j=gap; j<arr.length; i++,j++ ){
                System.out.println(arr[i][j]);
            }
        }
    }
}
