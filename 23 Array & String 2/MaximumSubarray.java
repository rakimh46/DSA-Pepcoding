public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum=0, sum=Integer.MIN_VALUE, size=nums.length;
        for(int i=0; i<size;i++){
            if(currentSum<0){ 
                currentSum=nums[i];
            }else{
                currentSum+=nums[i];
            }
            if(sum<currentSum) sum = currentSum;
            
        }
        return sum;
    }
}
