//Given an integer array nums, find the contiguous subarray (containing at least one number) 
//which has the largest sum and return its sum.
public class maximumsubarray {
    public static void main(String[] args) {
        int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int ans = maxsubarray(a1);
        System.out.println(ans);
    }

    public static int maxsubarray(int[] a1) {

        int currentsum=0, sum=Integer.MIN_VALUE;

        for (int i = 0; i < a1.length; i++) {
            currentsum+=a1[i];
            if(currentsum>sum) sum=currentsum;
            System.out.print(currentsum+" ");
            if(currentsum<0) currentsum=0;
        }
        return sum;
    }

}
