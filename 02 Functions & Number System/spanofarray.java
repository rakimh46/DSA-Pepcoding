//span of array is diffrence between of max and min in array 

public class spanofarray {
    public static void main(String[] args) {
        int[] arr = { 15, 30, 40, 4, 11, 9 };
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int i = 0;
        while (i < arr.length) {
            if (arr[i] > max) {
                max=arr[i];
            }
            if (arr[i] < min) {
                min=arr[i];
            } 
            i++;
        }
        System.out.println(max-min);
    }

}
