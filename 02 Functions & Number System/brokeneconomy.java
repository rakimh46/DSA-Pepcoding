public class brokeneconomy {
    public static void main(String[] args) {
        int[] arr = { 5, 10, 15, 22, 33, 40, 42, 55 };
        int d = 25;
        int[] ans=economy(arr, d);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }

    public static int[] economy(int[] arr, int ele) {
        int lo=0,hi=arr.length-1;
        int ceil=Integer.MAX_VALUE,floor=Integer.MIN_VALUE;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]==ele){
                ceil=ele;
                floor=ele;
                break;
            }
            else if(ele<arr[mid]){
                ceil=arr[mid];
                hi=mid-1;
                //System.out.println("2.."+arr[mid]+" "+lo+" "+hi+" "+ceil+" "+floor);
            }else{
                floor=arr[mid];
                lo=mid+1;
                //System.out.println("1.."+arr[mid]+" "+lo+" "+hi+" "+ceil+" "+floor );
            }
        }
        return new int[] {ceil,floor};
    }
}
