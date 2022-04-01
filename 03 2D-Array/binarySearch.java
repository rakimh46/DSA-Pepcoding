public class binarySearch {
    public static void main(String[] args) {
        int[] arr={-1,2,4,5,9,10,11,14,15};
        int target=9;

        int i=0; //first index
        int j=arr.length-1; // last index

        while(i<=j){
            int mid=i+(j-i)/2;
            if(target>arr[mid]){
                i=mid+1;
            }else if(target<arr[mid]){
                j=mid-1;

            }else if(target==arr[mid]){
                System.out.println(mid);
                break;
            }
        }
        

    }
    
}
