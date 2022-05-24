import java.util.Arrays;

public class BoatsSavePeople {
    //leetcode
    public int numRescueBoats(int[] people, int limit) {
        int[] buckets = new int[limit + 1];

        for (int p : people) {
            buckets[p]++;
        }

        int left = 0;
        int right = limit;

        int boat = 0;

        while (left <= right) {

            while (left <= right && buckets[left] == 0) {
                left++;
            }
            while (left <= right && buckets[right] == 0) {
                right--;
            }

            if (buckets[left] <= 0 && buckets[right] <= 0) {
                break;
            }
            if (left + right <= limit) {
                buckets[left]--;
            }
            buckets[right]--;
            boat++;
        }
        return boat;
    }

    //pepcoding
    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);
        int boat=0;
        
        int i=0,j=people.length-1;
        while(i<=j){
            if(people[j]>=limit){
                boat++;
                j--;
            }else{
                int sum=people[j]+people[i];
                if(sum<=limit){
                    boat++;
                    i++;
                    j--;
                }else{
                    boat++;
                    j--;
                }
            }
        }
        return boat;
    }
}
