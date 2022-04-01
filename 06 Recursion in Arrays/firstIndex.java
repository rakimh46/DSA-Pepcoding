public class firstIndex {
    public static void main(String[] args) {
        int[] arr={15,11,4,10,4,4,9};
        int x=4;
        System.out.println( firstindex(arr,0,x));
    }

    public static int firstindex(int[] arr,int idx,int x) {
        if(arr[idx]==x){
            return idx;
        }
        if(idx==arr.length){
            return -1;
        }
    
        return firstindex(arr, idx+1, x);

    }
}
