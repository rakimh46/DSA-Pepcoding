public class firstandlastindex {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 20, 20, 30, 30, 40, 50, 50, 60, 60, 70 };
        int d = 20;
        int[] ans = fandl(arr, d);
        for (int i : ans) {
            System.out.println(i);
        }

    }

    public static int[] fandl(int[] arr, int d) {

        int lo = 0, hi = arr.length - 1;
        int fi = -1;
        while (lo <= hi) {
            int mid=(lo+hi)/2;
            if(d<arr[mid]){
                hi=mid-1;
            }else if(d>arr[mid]){
                lo=mid+1;
            }else{
                fi=mid;
                hi=mid-1;
            }
        }
        lo = 0; 
        hi = arr.length - 1;
        int li=-1;
        while (lo <= hi) {
            int mid=(lo+hi)/2;
            if(d<arr[mid]){
                hi=mid-1;
            }else if(d>arr[mid]){
                lo=mid+1;
            }else{
                li=mid;
                lo=mid+1;
            }
        }

        return new int[] {fi,li};

    }
}
