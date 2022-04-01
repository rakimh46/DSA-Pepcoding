public class lastIndex {
    public static void main(String[] args) {
        int[] arr={15,11,4,10,4,4,9};
        int x=4;
        System.out.println( lastindex(arr,arr.length-1,x));
    }

    public static int lastindex(int[] arr,int idx,int x) {
        if(arr[idx]==x){
            return idx;
        }
        if(idx<0){
            return -1;
        }
    
        return lastindex(arr, idx-1, x);

    }
}
